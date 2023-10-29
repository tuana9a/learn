package com.tuana9a.learnjavaservlet.listeners;

import com.tuana9a.learnjavaservlet.configs.AppConfig;
import com.tuana9a.learnjavaservlet.DatabaseManager;
import com.tuana9a.learnjavaservlet.ThreadPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println(this.getClass().getName() + " is loading servlet context");
        AppConfig config = AppConfig.getInstance();
        config.load();
        ThreadPool threadPool = ThreadPool.getInstance();
        threadPool.execute(() -> DatabaseManager.getInstance().createConnection(config.DATABASE_URL(), config.DATABASE_USERNAME(), config.DATABASE_PASSWORD()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
