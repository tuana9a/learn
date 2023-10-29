package com.tuana9a.learnjavathread;

import com.tuana9a.learnjavathread.ex3.MyRunnable;
import com.tuana9a.learnjavathread.ex3.SimpleThread;
import org.junit.jupiter.api.Test;

public class LearnJavaThreadTests {
    @Test
    public void testSimpleThread() throws InterruptedException {
        SimpleThread t1 = new SimpleThread("1");
        MyRunnable t2 = new MyRunnable("2") {
            @Override
            public void run() {
                for (int i = 0; i < 2; ++i) {
                    System.out.println("THREAD " + name + ": " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("=========== END THREAD " + name + " ===============");
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();
        Thread.sleep(10_000); // make main thread don't exit
    }
}
