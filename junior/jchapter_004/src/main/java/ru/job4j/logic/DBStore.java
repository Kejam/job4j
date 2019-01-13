package ru.job4j.logic;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.SortedMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DBStore implements Store<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();

    public DBStore() {
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("fghrty212vyt");
        SOURCE.setDriverClassName("org.postgresql.Driver");
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
             PreparedStatement ps = connection.prepareStatement("insert into DBSTORE (name, login, email, createDate, password) values (?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, "root");
            ps.setString(2,"root");
            ps.setString(3, "root");
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5,"root");
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return count == 0;
    }


    private void createTable() {
        try (Connection connection = SOURCE.getConnection()){
            final PreparedStatement ps = connection.prepareStatement(
                    "create table if not exists DBSTORE(id serial primary key, name character(2000), login character(2000), email character(2000), createDate timestamp, password character(2000))"
            );
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into DBSTORE (name, login, email, createDate, password) values (?, ?, ?, ?, ?)");
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            ps.setString(5, user.getPassword());
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(int id, User user) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("update DBSTORE set name = ?, login = ?, email = ? password = ? where id = ?");
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, id);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from DBSTORE where id = ?");
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public CopyOnWriteArrayList<User> findAll() {
        CopyOnWriteArrayList<User> list = null;
        try (Connection connection = SOURCE.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from DBSTORE");
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("date"),
                        rs.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from DBSTORE where id = ?");
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("email"),
                        rs.getString("date"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean isCredential(String login, String password) {
        boolean result = false;
        User user;
        try (Connection connection = SOURCE.getConnection()) {
            try (PreparedStatement st = connection.prepareStatement("SELECT * FROM DBSTORE WHERE login = ? AND password = ?")) {
                st.setString(1, login);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    user = new User(
                            rs.getString("login"),
                            rs.getString("password")
                    );
                    if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                        result = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
