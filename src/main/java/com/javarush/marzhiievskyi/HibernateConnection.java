package com.javarush.marzhiievskyi;

import com.javarush.marzhiievskyi.domain.City;
import com.javarush.marzhiievskyi.domain.Country;
import com.javarush.marzhiievskyi.domain.CountryLanguage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.util.Objects.isNull;

public class HibernateConnection {
    private static HibernateConnection instance;
    private final SessionFactory sessionFactory;


    public HibernateConnection() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(CountryLanguage.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionfactory() {
        if (isNull(instance)) {
            instance = new HibernateConnection();
        }

        return instance.sessionFactory;
    }
}
