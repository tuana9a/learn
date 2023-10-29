package com.tuana9a.learnjavaservletwebsocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println(this.getClass().getName() + " is loading servlet context");
        ThreadPool threadPool = ThreadPool.getInstance();
        threadPool.execute(new UpdateClock());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

    }

}
