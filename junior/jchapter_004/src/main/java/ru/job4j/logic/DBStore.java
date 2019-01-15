package ru.job4j.logic;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class DBStore implements Store, AutoCloseable{
    private static final Logger LOG = LogManager.getLogger(DBStore.class.getName());
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();

    public DBStore() {
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("fghrty212vyt");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        createTable();
        if (isEmpty()) {
            addRootUser();
        }
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    private void addRootUser() {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into dbstore (name, login, email, createDate, password, role) values (?, ?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, "root");
            ps.setString(2,"root");
            ps.setString(3, "root");
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5,"root");
            ps.setInt(6, 0);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private boolean isEmpty() {
        int count = 0;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("Select count(*) dbstore");
        ) {
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
              count += rs.getInt(1);
          }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return count == 0;
    }


    private void createTable() {
        try (Connection connection = SOURCE.getConnection()){
            final PreparedStatement ps = connection.prepareStatement(
                    "create table if not exists dbstore(id serial primary key, name character(2000), login character(2000), email character(2000), createDate timestamp, password character(2000), role integer)"
            );
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into dbstore (name, login, email, createDate, password, role) values (?, ?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getRole());
            result = ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean update(int id, User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("update dbstore set name = ?, login = ?, email = ?, password = ?, role = ?, createDate = ? where id = ?");
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole());
            ps.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            ps.setInt(7, id);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from dbstore where id = ?");
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public CopyOnWriteArrayList<User> findAll() {
        CopyOnWriteArrayList<User> list = null;
        try (Connection connection = SOURCE.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from dbstore");
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(this.getByResultSet(rs));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }

    private User getByResultSet(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("login"),
                rs.getString("email"),
                rs.getString("createDate"),
                rs.getString("password"),
                rs.getInt("role")
        );
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from dbstore where id = ?");
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = getByResultSet(rs);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return user;
    }

    public int role(String login, String password) {
       int result = -1;
       try (Connection connection = SOURCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from dbstore where login = ?");
            ) {
                ps.setString(1, login);
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 result = (int) rs.getInt("role");
                 break;
             }
       } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
       return result;
    }

    public boolean isCredential(String login, String password) {
        boolean result = false;
        for (User user: findAll()) {
            if (user.getLogin().equals(login) && user.getID().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        SOURCE.close();
    }
}
