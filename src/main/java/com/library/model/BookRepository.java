package com.library.model;

import com.library.model.entity.BookDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BookRepository implements Repository<BookDAO> {

    private final static Logger LOG = LoggerFactory.getLogger(BookRepository.class);

    private final SessionFactory sessionFactory;

    private static final String FIND_ALL = "SELECT id, name, count_pages, publication_year, author, description , genre " +
            "FROM book";

    public BookRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int addPublication(BookDAO bookDAO) {
        Transaction transaction = null;
        int id = 0;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            id = (int) session.save(bookDAO);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(String.format("addPublication. book.name=%s, book.author=%s", bookDAO.getName(), bookDAO.getAuthor()), e);
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
        }

        return id;
    }

    @Override
    public BookDAO findById(int id) {
        BookDAO bookDAO = null;
        try (Session session = sessionFactory.openSession()) {
            return session.get(BookDAO.class, id);
        } catch (Exception ex) {
            LOG.error(String.format("findById. book.id=%s", id), ex);
        }
        return bookDAO;
    }

    @Override
    public List<BookDAO> findAll() {
        try(Session session = sessionFactory.openSession()) {
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
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(bookDAO);
            transaction.commit();
        } catch (Exception e) {
            LOG.error(String.format("update. book.name=%s, book.author=%s", bookDAO.getName(), bookDAO.getAuthor()), e);
            ;
            if (Objects.nonNull(transaction)) {
                transaction.rollback();
            }
        }
    }

    public List<BookDAO> findByAuthor(String authorName) {
        List<BookDAO> bookDAO = null;
        try (Session session = sessionFactory.openSession()) {
            bookDAO = session.createQuery("FROM BookDAO b where b.author=:author", BookDAO.class)
                    .setParameter("author", authorName)
                    .list();
        } catch (Exception ex) {
            LOG.error(String.format("findByAuthor. book.author=%s", authorName), ex);
        }

        return bookDAO;
    }
}
