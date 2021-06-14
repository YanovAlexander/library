package com.library.model;

import com.library.model.entity.BookDAO;
import com.library.service.BookConverter;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Collections;
import java.util.List;

public class BookRepository implements Repository<BookDAO> {

    private final static Logger LOG = LoggerFactory.getLogger(BookRepository.class);

    private final HikariDataSource dataSource;
    private static final String INSERT = "INSERT INTO book (name, count_pages, publication_year, author, description , genre) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT id, name, count_pages, publication_year, author, description , genre " +
            "FROM book WHERE id = ?";
    private static final String FIND_ALL = "SELECT id, name, count_pages, publication_year, author, description , genre " +
            "FROM book";


    public BookRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public long addPublication(BookDAO bookDAO) {
        long id = 0;
        try (Connection connection = dataSource.getConnection();
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
            LOG.error(String.format("addPublication. book.name=%s, book.author=%s", bookDAO.getName(), bookDAO.getAuthor()), ex);
        }
        return id;
    }

    @Override
    public BookDAO findById(long id) {
        BookDAO bookDAO = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            bookDAO = BookConverter.toBookDAO(resultSet);
        } catch (SQLException ex) {
            LOG.error(String.format("findById. book.id=%s", id), ex);
        }
        return bookDAO;
    }

    @Override
    public List<BookDAO> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return BookConverter.toBookDAOCollection(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
