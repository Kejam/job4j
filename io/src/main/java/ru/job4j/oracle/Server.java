package ru.job4j.oracle;

import ru.job4j.bot.Bot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    private static final int PORT = 5050;
    private String message = "";
    private Bot bot = new Bot();

    public boolean start() {
        boolean result = false;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket socket = serverSocket.accept();
            if (socket.isConnected()) {
                result = true;
                System.out.println("Server is start");
            }
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            do {
                message = in.readUTF();
                out.writeUTF(bot.say());
                out.flush();
            } while (!message.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        new Server().start();
    }
}
