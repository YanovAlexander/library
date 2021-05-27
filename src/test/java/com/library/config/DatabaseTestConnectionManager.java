package com.library.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseTestConnectionManager implements DatabaseManager {
    private HikariDataSource ds;

    public DatabaseTestConnectionManager() {
        initDataSource();
    }

    @Override
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    private void initDataSource() {
        HikariConfig config = new HikariConfig();
        Properties properties = new Properties();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("application-test.properties")){
            properties.load(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        config.setJdbcUrl(properties.getProperty("jdbc.url"));
        ds = new HikariDataSource(config);
    }
}
