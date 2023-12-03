package com.tuana9a.learnjavathread.ex2;

public class ThreadThatThatCheckResource extends ThreadThatUseResource {

    public ThreadThatThatCheckResource(String name, SharedResource resource) {
        super(name, resource);
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; ++i) {
            System.out.println("THREAD " + name + ": " + resource.getResource());
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
