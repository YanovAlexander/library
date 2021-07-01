package com.library.model;

import com.library.model.entity.JournalDAO;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;


public class JournalRepository implements Repository<JournalDAO> {
    private final static Logger LOG = LoggerFactory.getLogger(JournalRepository.class);

    private final HikariDataSource dataSource;
    private final static String INSERT = "INSERT INTO journal (name, count_pages, year, description, journal_type, number) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    public JournalRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int save(JournalDAO journalDAO) {
        int id = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, journalDAO.getName());
            statement.setInt(2, journalDAO.getCountPages());
            statement.setInt(3, journalDAO.getYear());
            statement.setString(4, journalDAO.getDescription());
            statement.setString(5, journalDAO.getJournalType().name());
            statement.setInt(6, journalDAO.getNumber());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            LOG.error(".addPublication. Exception happened with saving journal", throwables);
        }
        return id;
    }

    @Override
    public JournalDAO findById(int id) {
        return null;
    }

    @Override
    public List<JournalDAO> findAll() {
        return null;
    }

    @Override
    public void update(JournalDAO entity) {
    }
}