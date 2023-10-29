package com.tuana9a.learnjavathread.ex3;

public abstract class MyRunnable implements Runnable {
    public String name;

    public MyRunnable(String name) {
        this.name = name;
    }
}
