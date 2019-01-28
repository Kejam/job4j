package ru.job4j.oracle;

import ru.job4j.bot.User;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final int PORT = 5050;
    private static final String IP = "127.0.0.1";
    private String message = "";
    private User user = new User();

    public boolean start() {
        boolean result = false;
        try {
            InetAddress inetAddress = InetAddress.getByName(IP);
            Socket socket = new Socket(inetAddress, PORT);
            if (socket.isConnected()) {
                result = true;
                System.out.println("Client is start");
            }
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            do {
                System.out.println("Input value to server");
                message = user.say();
                out.writeUTF(message);
                out.flush();
                message = in.readUTF();
                System.out.println("Server reply :" + message);
            } while (!message.equals("exit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        new Client().start();
    }
}
