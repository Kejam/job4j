package ru.job4j.bot;

import java.util.Scanner;

public class User {
    private Scanner scanner = new Scanner(System.in);

    public String say() {
        return scanner.nextLine();
    }
}
