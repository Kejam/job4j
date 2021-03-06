package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;

    public TrackerSQL() {
        this.init();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            if (!checkTable()) {
                creatTable();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }
    @Override
    public Item add(Item item)  {
        Item item1 = item;
        try (PreparedStatement ps  = this.connection.prepareStatement("insert into tracker(name, description, timeCreate) values (?,?,?)")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item1;
    }

    @Override
    public void replace(String id, Item item) {
        try (PreparedStatement ps = this.connection.prepareStatement("update tracker set name = ?, description = ? where id = ? ")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setInt(3, Integer.parseInt(item.getId()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try (PreparedStatement ps = this.connection.prepareStatement("delete from tracker where id = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Item[] findAll() {
        Item[] items = new Item[100];
        int index = 0;
        try (PreparedStatement ps = this.connection.prepareStatement("select * from tracker")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items[index++] = new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item[] findByName(String key) {
        Item[] items = new Item[countTable()];
        int index = 0;
        try (PreparedStatement ps = this.connection.prepareStatement("select * from tracker where name = ?")) {
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                items[index++] = new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement ps = this.connection.prepareStatement("select * from tracker where id = ?")) {
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item = new Item(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private void creatTable() {
         try {
             PreparedStatement ps = this.connection.prepareStatement("create table tracker (id serial primary key,name varchar(2000),description text,timeCreate timestamp);");
             ps.execute();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    private boolean checkTable() {
        boolean result = false;
        try {
            DatabaseMetaData dbm = this.connection.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "tracker", null);
            if (tables.next()) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int countTable() {
        int count = 0;
        try (PreparedStatement ps = this.connection.prepareStatement("select count(*) from tracker;")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
