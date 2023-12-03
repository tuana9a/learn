package com.tuana9a.learnjavahibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateApplication {
    private static final HibernateApplication instance = new HibernateApplication();

    private SessionFactory sessionFactory;

    private HibernateApplication() {

    }

    public static HibernateApplication getInstance() {
        return instance;
    }

    public void initSessionFactor() {
        Configuration cfg = new Configuration();
        String[] mappers = new String[]{"Car.hbm.xml"}; // custom mapper not in hibernate.cfg.xml
        for (String path : mappers) {
            cfg.addResource(path);
        }
        sessionFactory = cfg.configure(new File("hibernate.cfg.xml")).buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
