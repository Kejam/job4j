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
        while (message.equals("stop")) {
            System.out.println("Input message");
            message = receiveMessage();
            if (message.equals("stop")) {
                bot.stop();
            }
            if (message.equals("cont")) {
                bot.start();
            }
            System.out.println(sendMessage());
        }
    }

    public static void main(String[] args) {
        new ChatBot().init();
    }
}
