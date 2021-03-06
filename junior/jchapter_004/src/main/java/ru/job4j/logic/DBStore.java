package ru.job4j.logic;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class DBStore implements Store, AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(DBStore.class.getName());
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();

    public DBStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
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
             PreparedStatement ps = connection.prepareStatement("insert into clients (name, login, email, createDate, password, role) values (?, ?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, "root");
            ps.setString(2, "root");
            ps.setString(3, "root");
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5, "root");
            ps.setInt(6, 0);
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private boolean isEmpty() {
        int count = 0;
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("Select count(*) from clients");
        ) {
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
              count = rs.getInt(1);
              if (count == 0) {
                  result = true;
                  break;
              }
          }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }


    private void createTable() {
        try (Connection connection = SOURCE.getConnection()) {
            final PreparedStatement ps = connection.prepareStatement(
                    "create table if not exists clients(id serial primary key, name varchar(2000), login varchar(2000), email varchar(2000), createDate timestamp, password varchar(2000), role integer)"
            );
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public User findByLogin(User user) {
        User user1 = new User();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from clients where login = ?");
        ) {
            ps.setString(1, user.getLogin());
            final ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user1 = getByResultSet(rs);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return user1;
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into clients (name, login, email, createDate, password, role) values (?, ?, ?, ?, ?, ?)");
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
             PreparedStatement ps = connection.prepareStatement("update clients set name = ?, login = ?, email = ?, password = ?, role = ?, createDate = ? where id = ?");
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
             PreparedStatement ps = connection.prepareStatement("delete from clients where id = ?");
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
        CopyOnWriteArrayList<User> list = new CopyOnWriteArrayList<>();
        try (Connection connection = SOURCE.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from clients");
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
                rs.getString("createdate"),
                rs.getString("password"),
                rs.getInt("role")
        );
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from clients where id = ?");
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

    public int role(User user) {
       int result = -1;
       try (Connection connection = SOURCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from clients where login = ?");
            ) {
                ps.setString(1, user.getLogin());
             ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                 result = rs.getInt("role");
                 break;
             }
       } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
       return result;
    }

    public boolean isCredential(String login, String password) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
            PreparedStatement ps = connection.prepareStatement("select * from clients where login = ?");
        ) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    result = true;
                    break;
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        SOURCE.close();
    }
}
