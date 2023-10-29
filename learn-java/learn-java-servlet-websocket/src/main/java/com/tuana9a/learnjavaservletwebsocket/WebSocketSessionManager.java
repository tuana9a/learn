package com.tuana9a.learnjavaservletwebsocket;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;

public class WebSocketSessionManager {
    private static final WebSocketSessionManager instance = new WebSocketSessionManager();
    private final Hashtable<String, Session> sessions = new Hashtable<>();

    private WebSocketSessionManager() {

    }

    public static WebSocketSessionManager getInstance() {
        return instance;
    }

    public void addSession(Session session) {
        if (session == null) return;
        sessions.put(session.getId(), session);
    }

    public void removeSession(Session session) {
        if (session == null) return;
        sessions.remove(session.getId());
        try {
            session.close();
        } catch (IOException ignored) {
        }
    }

    public Set<String> getSessionIds() {
        return sessions.keySet();
    }

    public void sendMessage(String sessionId, String message) {
        if (sessionId == null) return;
        Session session = sessions.get(sessionId);
        if (session == null) return;
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
