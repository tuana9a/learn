package com.tuana9a.learnjavanetwork.socket;

import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 6969);
    }
}
