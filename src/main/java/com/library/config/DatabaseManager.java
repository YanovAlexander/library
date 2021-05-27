package com.library.config;

import java.sql.Connection;

public interface DatabaseManager {
    Connection getConnection();
}
