package com.tuana9a.learnjavathread.ex2;

public class ThreadThatUseResource extends Thread {
    String name;
    SharedResource resource;

    public ThreadThatUseResource(String name, SharedResource resource) {
        this.name = name;
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; ++i) {
            resource.increase();
            System.out.println("THREAD " + name + ": " + resource.getResource());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
