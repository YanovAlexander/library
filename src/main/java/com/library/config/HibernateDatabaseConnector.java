package com.library.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;

public class HibernateDatabaseConnector {
    private SessionFactory sessionFactory;
    private final static Logger LOG = LoggerFactory.getLogger(HibernateDatabaseConnector.class);

    public HibernateDatabaseConnector() {
        try {
            MetadataSources source = new MetadataSources(new StandardServiceRegistryBuilder().configure().build());
            final Metadata metadata = source.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            LOG.error("init. ", e);
        }
    }

    @PreDestroy
    public synchronized void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
