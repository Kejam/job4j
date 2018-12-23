package ru.job4j.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class StoreSQL {
    private final Logger sqLiteLog = LogManager.getLogger(StoreSQL.class);
    private final Connection connection;

    public StoreSQL(Config config) {
        try {
            this.connection = DriverManager.getConnection(config.get("url"));
            if (this.connection != null) {
                DatabaseMetaData meta = this.connection.getMetaData();
                this.sqLiteLog.info(String.format("The driver name is: %s", meta.getDriverName()));
                this.sqLiteLog.info("Connection to SQLite has been established.");
            }
        } catch (Exception e) {
            this.sqLiteLog.error(e.getMessage(), e);
            throw new IllegalStateException(e);
        }
    }
}
