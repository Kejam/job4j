package ru.job4j.bot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChatBot {

    public void init() {
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
            System.out.println(bot.say());
        }
    }

    public static void main(String[] args) {
        new ChatBot().init();
    }
}
