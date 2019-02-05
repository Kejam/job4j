package job4j.carStrorage.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

public class Wrapper {
    private static final Logger LOG = LogManager.getLogger(UserStorage.class.getName());
    public void wrapperMethodVoid(Consumer<Session> command, SessionFactory factory) {
        Transaction transaction = null;
        try {Session session = factory.openSession();
            transaction = session.beginTransaction();
            command.accept(session);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        }
    }

    public  <T> T wrapperMethodT(final Function<Session, T> command, SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.apply(session);
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            tx.commit();
            session.close();
        }
    }
}
