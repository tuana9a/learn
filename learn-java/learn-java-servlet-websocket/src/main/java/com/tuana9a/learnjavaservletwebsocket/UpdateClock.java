package com.tuana9a.learnjavaservletwebsocket;

public class UpdateClock implements Runnable {
    public UpdateClock() {
    }

    @Override
    public void run() {
        while (true) {
            WebSocketSessionManager repository = WebSocketSessionManager.getInstance();
            repository.getSessionIds().forEach(sessionId -> repository.sendMessage(sessionId, String.valueOf(System.currentTimeMillis())));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
