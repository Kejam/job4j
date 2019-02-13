package job4j;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
    private final BasicDataSource source;
    private final Properties props = new Properties();

    public ConnectionFactory(String propsName) {
        BasicDataSource source = new BasicDataSource();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(propsName)) {
            this.props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        source.setDriverClassName(this.props.getProperty("driverClassName"));
        source.setUrl(this.props.getProperty("url"));
        source.setUsername(this.props.getProperty("userName"));
        source.setPassword(this.props.getProperty("password"));
        source.setMinIdle(5);
        source.setMaxIdle(10);
        source.setMaxOpenPreparedStatements(100);
        this.source = source;
        this.createStructure();
    }

    private void createStructure() {
        try (Connection con = this.source.getConnection();
             Statement st = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users(id SERIAL PRIMARY KEY, name varchar(50))";
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect() {
        Connection result = null;
        try {
            result = this.source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
