package job4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcStorage implements Storage {
    private final ConnectionFactory factory;

    public JdbcStorage(ConnectionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void add(User user) {
        System.out.println("jdbc add");
        try (Connection con = this.factory.getConnect();
             PreparedStatement st = con.prepareStatement("INSERT INTO users(id, name) values(?, ?)")) {
            st.setString(2, user.getName());
            st.setInt(1,user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public User get(Integer id) {
        User user = new User();
        try (Connection con = this.factory.getConnect();
             PreparedStatement st = con.prepareStatement("SELECT name FROM users WHERE id = ?")) {
            st.setInt(1, id);
            try (ResultSet rst = st.executeQuery()) {
                while (rst.next()) {
                    user.setId(id);
                    user.setName(rst.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try(
                Connection connection = this.factory.getConnect();
                PreparedStatement ps = connection.prepareStatement("select * from users")
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
