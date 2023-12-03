package com.tuana9a.learnjavaservletwebsocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class WebSocketServer {

    @OnOpen
    public void onOpen(Session session) {
        WebSocketSessionManager service = WebSocketSessionManager.getInstance();
        service.addSession(session);
    }

    @OnClose
    public void onClose(Session session) {
        WebSocketSessionManager service = WebSocketSessionManager.getInstance();
        service.removeSession(session);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
        WebSocketSessionManager service = WebSocketSessionManager.getInstance();
        service.removeSession(session);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        // do nothing
    }

}
