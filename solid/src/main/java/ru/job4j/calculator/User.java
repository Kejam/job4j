package ru.job4j.calculator;

import java.util.Scanner;

/**
 * This class implements simple user.
 * @author Prozorov Aleksey (kejamwork@mail.ru).
 * @version 0.1
 */
public class User {
    /**
     * User input value and then return.
     * @return
     */
    public String input() {
        return new Scanner(System.in).nextLine();
    }
}
