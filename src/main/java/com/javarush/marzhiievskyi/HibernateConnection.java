package com.javarush.marzhiievskyi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.util.Objects.isNull;

public class HibernateConnection {
    private static HibernateConnection instance;
    private final SessionFactory sessionFactory;


    public HibernateConnection() {
        sessionFactory = new Configuration()

                .buildSessionFactory();
    }

    public static SessionFactory getSessionfactory() {
        if (isNull(instance)) {
            instance = new HibernateConnection();
        }

        return instance.sessionFactory;
    }
}
