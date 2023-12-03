package com.tuana9a.learnjavathread.ex3;

public class SimpleThread implements Runnable {
    String name;

    public SimpleThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("THREAD " + name + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=========== END THREAD " + name + " ===============");
    }
}
