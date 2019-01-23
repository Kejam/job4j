package ru.job4j.oracle;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 5050;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        DataInputStream in = new DataInputStream(inputStream);
        DataOutputStream out = new DataOutputStream(outputStream);

        String value = "";

        while (true) {
            value = in.readUTF();
            out.writeUTF(value += value);
            out.flush();
        }
    }
}
