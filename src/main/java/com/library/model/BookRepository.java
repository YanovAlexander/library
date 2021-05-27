package com.library.model;

import com.library.config.DatabaseConnectionManager;
import com.library.config.DatabaseManager;
import com.library.model.entity.BookDAO;
import com.library.service.BookConverter;

import java.sql.*;

public class BookRepository implements Repository<BookDAO> {
    private final DatabaseManager connectionManager;
    private static final String INSERT = "INSERT INTO book (name, count_pages, publication_year, author, description , genre) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT id, name, count_pages, publication_year, author, description , genre " +
            "FROM book WHERE id = ?";


    public BookRepository(DatabaseManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public long addPublication(BookDAO bookDAO) {
        long id = 0;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, bookDAO.getName());
            statement.setInt(2, bookDAO.getCountPages());
            statement.setInt(3, bookDAO.getPublicationYear());
            statement.setString(4, bookDAO.getAuthor());
            statement.setString(5, bookDAO.getDescription());
            statement.setString(6, bookDAO.getGenre().name());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getLong(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    @Override
    public BookDAO findById(long id) {
        BookDAO bookDAO = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            bookDAO = BookConverter.toBookDAO(resultSet);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookDAO;
    }
}
