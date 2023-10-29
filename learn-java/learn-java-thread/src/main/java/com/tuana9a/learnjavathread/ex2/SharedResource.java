package com.tuana9a.learnjavathread.ex2;

public class SharedResource {
    protected int resource;

    public SharedResource() {
        resource = 0;
    }

    public void increase() {
        resource++;
    }

    public int getResource() {
        return resource;
    }
}
