package com.library.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppInit  implements ServletContextListener {

    private final static Logger LOG = LoggerFactory.getLogger(AppInit.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.debug("Init database connection manager");
        DatabaseConnectionManager.init();
        System.out.println("Database init finished");
        LOG.debug("Database init finished");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
