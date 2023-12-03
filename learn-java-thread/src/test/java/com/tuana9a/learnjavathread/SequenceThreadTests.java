package com.tuana9a.learnjavathread;

import com.tuana9a.learnjavathread.ex1.Monitor;
import com.tuana9a.learnjavathread.ex1.ThreadThatRunSequence;
import org.junit.jupiter.api.Test;

public class SequenceThreadTests {
    @Test
    public void testSequenceThread() throws InterruptedException {
        Monitor lock = new Monitor(1);
        ThreadThatRunSequence t1 = new ThreadThatRunSequence("1", lock, 0);
        ThreadThatRunSequence t2 = new ThreadThatRunSequence("2", lock, 1);
        t2.start();
        t1.start();
        Thread.sleep(5_000); // make main thread don't exit
    }
}
