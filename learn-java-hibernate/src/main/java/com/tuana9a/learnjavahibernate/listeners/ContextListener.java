package com.tuana9a.learnjavahibernate.listeners;


import com.tuana9a.learnjavahibernate.HibernateApplication;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        HibernateApplication.getInstance().initSessionFactor();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
