package com.springapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.io.File;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;
    // I know this is really stupid, but I can't figure out how to load the configuration without an absolute path
    private static final String CONFIG_FILE_PATH =  "/Users/connorboyd/Spring2015/ObjectOriented/Project/CharitEBay/src/main/java/com/springapp/hibernate.cfg.xml";

    public static SessionFactory getFactory() {
        if(sessionFactory == null) { // Build session factory if it's null
            Configuration config = new Configuration();
            ServiceRegistry serviceRegistry;

            // config.setProperty("connection.username", "root");
            // config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost/charitebay");
            // config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
            // config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            File cfgFile = new File(CONFIG_FILE_PATH);
            config.configure(cfgFile);
            serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
