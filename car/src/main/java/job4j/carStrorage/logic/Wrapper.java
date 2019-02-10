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
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            tx = session.beginTransaction();
            command.accept(session);
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public  <T> T wrapperMethodT(final Function<Session, T> command, SessionFactory factory) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T result = command.apply(session);
            tx.commit();
            return result;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
