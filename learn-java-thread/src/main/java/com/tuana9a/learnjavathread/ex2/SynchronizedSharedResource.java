package com.tuana9a.learnjavathread.ex2;

public class SynchronizedSharedResource extends SharedResource {
    @Override
    public synchronized void increase() {
        resource++;
    }
}
