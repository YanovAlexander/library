package com.library.model;

import com.library.config.HibernateDatabaseConnector;
import com.library.model.entity.BookDAO;
import com.library.model.mapper.BookDAOMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@org.springframework.stereotype.Repository
public class BookRepository implements Repository<BookDAO> {

    private final static Logger LOG = LoggerFactory.getLogger(BookRepository.class);

    private final JdbcTemplate jdbcTemplate;

    private final HibernateDatabaseConnector hibernateDatabaseConnector;

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate, HibernateDatabaseConnector databaseConnector) {
        this.jdbcTemplate = jdbcTemplate;
        this.hibernateDatabaseConnector = databaseConnector;
    }

    @Override
    public int save(BookDAO bookDAO) {
        final String insertSql = "INSERT INTO book(author_id, name, count_pages, publication_year, description, genre) " +
                "VALUES(?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            final PreparedStatement preparedStatement = connection.prepareStatement(insertSql, new String[]{"id"});
            preparedStatement.setInt(1, bookDAO.getAuthor().getId());
            preparedStatement.setString(2, bookDAO.getName());
            preparedStatement.setInt(3, bookDAO.getCountPages());
            preparedStatement.setInt(4, bookDAO.getPublicationYear());
            preparedStatement.setString(5, bookDAO.getDescription());
            preparedStatement.setString(6, bookDAO.getGenre().name());

            return preparedStatement;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public BookDAO findById(int id) {
        return jdbcTemplate.queryForObject("SELECT b.id as bookId, a.id as authorId, a.first_name as authorFirstName, " +
                "a.last_name as authorLastName, a.gender as authorGender, a.birth_date as authorBDay, b.name as bookName, " +
                "b.count_pages as bookPages, b.publication_year as bookPublicationYear, b.description as bookDescription," +
                " b.genre as bookGenre FROM book b JOIN author a ON b.author_id=a.id  WHERE b.id=?", new BookDAOMapper(), id);
    }

    @Override
    public List<BookDAO> findAll() {
        try (Session session = hibernateDatabaseConnector.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM BookDAO b", BookDAO.class)
                    .list();
        } catch (Exception ex) {
            LOG.error(String.format("findAll."), ex);
        }
        return Collections.emptyList();
    }

    @Override
    public void update(BookDAO bookDAO) {
        Transaction transaction = null;
        try (Session session = hibernateDatabaseConnector.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bookDAO);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(String.format("update. book.name=%s, book.id=%s", bookDAO.getName(), bookDAO.getId()), e);
            ;
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
        }
    }

    public List<BookDAO> findByAuthor(String authorName) {
        List<BookDAO> bookDAO = null;
        try (Session session = hibernateDatabaseConnector.getSessionFactory().openSession()) {
            bookDAO = session.createQuery("FROM BookDAO b where b.author=:author", BookDAO.class)
                    .setParameter("author", authorName)
                    .list();
        } catch (Exception ex) {
            LOG.error(String.format("findByAuthor. book.author=%s", authorName), ex);
        }

        return bookDAO;
    }
}
