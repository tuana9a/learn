package com.tuana9a.fileservlet.context;

import com.tuana9a.fileservlet.configs.AppConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        AppConfig config = AppConfig.getInstance();
        config.load();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
