package ru.job4j.bot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        User user =  new User();
        Bot bot = new Bot();
        String value = "";
        while (!value.equals("exit")) {
            System.out.println("Input message");
            value = user.say();
            if (value.equals("stop")) {
                bot.stop();
            }
            if (value.equals("cont")) {
                bot.start();
            }
            bot.say();
        }
    }
}
