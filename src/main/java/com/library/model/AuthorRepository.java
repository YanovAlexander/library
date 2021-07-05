package com.library.model;

import com.library.config.HibernateDatabaseConnector;
import com.library.model.entity.AuthorDAO;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class AuthorRepository implements Repository<AuthorDAO> {
    private final static Logger LOG = LoggerFactory.getLogger(AuthorRepository.class);

    private final HibernateDatabaseConnector hibernateDatabaseConnector;

    public AuthorRepository(HibernateDatabaseConnector hibernateDatabaseConnector) {
        this.hibernateDatabaseConnector = hibernateDatabaseConnector;
    }

    @Override
    public int save(AuthorDAO entity) {
        return 0;
    }

    @Override
    public AuthorDAO findById(int id) {
        try (Session session = hibernateDatabaseConnector.getSessionFactory().openSession()) {
            return session.get(AuthorDAO.class, id);
        } catch (Exception ex) {
            LOG.error(String.format("findById. author.id=%s", id), ex);
        }
        return null;
    }

    @Override
    public List<AuthorDAO> findAll() {
        try(Session session = hibernateDatabaseConnector.getSessionFactory().openSession()) {
            return session.createQuery("SELECT b FROM AuthorDAO b", AuthorDAO.class)
                    .list();
        } catch (Exception ex) {
            LOG.error(String.format("findAll."), ex);
        }
        return Collections.emptyList();
    }

    @Override
    public void update(AuthorDAO entity) {

    }
}
