package com.springapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class SessionFactorySingleton {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getFactory() {
        if(sessionFactory == null) { // Build session factory if it's null
            Configuration config = new Configuration();
            config.configure();
            serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(config.getProperties())
                    .buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
