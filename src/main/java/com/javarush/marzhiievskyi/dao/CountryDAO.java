package com.javarush.marzhiievskyi.dao;

import com.javarush.marzhiievskyi.domain.Country;
import org.hibernate.SessionFactory;

import java.util.List;

public class CountryDAO {
    private final SessionFactory sessionFactory;

    public CountryDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Country> getAllCountries() {
        return sessionFactory.getCurrentSession().createQuery(
                "select c from Country c join fetch c.languages", Country.class).list();
    }
}
