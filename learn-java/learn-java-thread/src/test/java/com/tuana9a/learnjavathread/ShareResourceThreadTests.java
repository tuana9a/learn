package com.tuana9a.learnjavathread;

import com.tuana9a.learnjavathread.ex2.SharedResource;
import com.tuana9a.learnjavathread.ex2.SynchronizedSharedResource;
import com.tuana9a.learnjavathread.ex2.ThreadThatThatCheckResource;
import com.tuana9a.learnjavathread.ex2.ThreadThatUseResource;
import org.junit.jupiter.api.Test;

public class ShareResourceThreadTests {
    @Test
    public void testSharedResource() throws InterruptedException {
        SharedResource resource = new SharedResource();
        ThreadThatUseResource t1 = new ThreadThatUseResource("1", resource);
        ThreadThatThatCheckResource t2 = new ThreadThatThatCheckResource("2", resource);
        t1.start();
        t2.start();

        Thread.sleep(10_000); // make main thread don't exit
    }

    @Test
    public void testSynchronizedSharedResource() throws InterruptedException {
        SharedResource resource = new SynchronizedSharedResource();
        ThreadThatUseResource t1 = new ThreadThatUseResource("1", resource);
        ThreadThatThatCheckResource t2 = new ThreadThatThatCheckResource("2", resource);
        t1.start();
        t2.start();

        Thread.sleep(10_000); // make main thread don't exit
    }
}
