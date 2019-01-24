package ru.job4j.bot;



public class ChatBot {
    private User user =  new User();
    private Bot bot = new Bot();
    private String message = "";

    public String sendMessage() {
        return bot.say();
    }

    public String receiveMessage() {
        return user.say();
    }


    public void init() {
        while (!message.equals("exit")) {
            System.out.println("Input message");
            message = sendMessage();
            if (message.equals("stop")) {
                bot.stop();
            }
            if (message.equals("cont")) {
                bot.start();
            }
            System.out.println(receiveMessage());
        }
    }

    public static void main(String[] args) {
        new ChatBot().init();
    }
}
