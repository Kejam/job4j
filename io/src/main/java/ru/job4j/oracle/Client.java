package ru.job4j.oracle;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        int port = 5050;
        String ip = "127.0.0.1";
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            Socket socket = new Socket(inetAddress, port);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String string = null;

            while (true) {
                System.out.println("Input value to server");
                string = reader.readLine();
                out.writeUTF(string);
                out.flush();
                string = in.readUTF();
                System.out.println("Server reply :" + string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
