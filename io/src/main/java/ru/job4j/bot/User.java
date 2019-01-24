package ru.job4j.bot;

import java.util.Scanner;

public class User {
    private Scanner scanner = new Scanner(System.in);
    private String input;

    public String say() {
        input = scanner.nextLine();
        return input;
    }

    public String say(String message) {
        input = message;
        return input;
    }

    public String getInput() {
        return input;
    }
}
