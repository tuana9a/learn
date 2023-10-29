package com.tuana9a.learnjavaservlet;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static  final ThreadPool instance = new ThreadPool();
    private final Executor executor;

    private ThreadPool() {
        executor = Executors.newFixedThreadPool(4);
    }

    public static ThreadPool getInstance() {
        return instance;
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }
}
