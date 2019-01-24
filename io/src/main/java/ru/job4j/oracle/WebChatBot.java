package ru.job4j.oracle;

public class WebChatBot {
    private Client client = new Client();
    private Server server = new Server();
    private boolean check;

    public void init() {
        check = server.start();
        if (check) {
            client.start();
        }
    }

    public static void main(String[] args) {
        new WebChatBot().init();
    }
}
