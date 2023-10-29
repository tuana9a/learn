package com.tuana9a.learnjavathread.ex1;

public class ThreadThatRunSequence extends Thread {
    String name;
    final Monitor monitor;
    int turn;

    public ThreadThatRunSequence(String name, Monitor monitor, int turn) {
        this.name = name;
        this.monitor = monitor;
        this.turn = turn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; ++i) {
            synchronized (monitor) {
                while (monitor.turn != turn) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("THREAD " + name + ": " + i);

                monitor.switchTurn();
                monitor.notify();
            }
        }
    }
}
