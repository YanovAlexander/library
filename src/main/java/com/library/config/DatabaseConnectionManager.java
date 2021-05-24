package com.library.config;

import com.library.util.PropertiesConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private HikariDataSource ds;

    public DatabaseConnectionManager(PropertiesConfig propertiesLoader) {
        initDataSource(propertiesLoader);
    }

    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables);
        }
    }

    private void initDataSource(PropertiesConfig propertiesLoader) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(String.format("jdbc:postgresql://%s/%s", propertiesLoader.getProperty("host"),
                propertiesLoader.getProperty("database.name")));
        config.setUsername(propertiesLoader.getProperty("username"));
        config.setPassword(propertiesLoader.getProperty("password"));
        config.setMaximumPoolSize(10);
        config.setIdleTimeout(10_000);
        config.setConnectionTimeout(10_000);
        ds = new HikariDataSource(config);
    }
}
