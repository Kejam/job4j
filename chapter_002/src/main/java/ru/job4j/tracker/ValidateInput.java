package ru.job4j.tracker;

import java.util.Scanner;

public class ValidateInput extends ConsoleInput {
    @Override
    public String answer(String question) {
        return super.answer(question);
    }
    @Override
    public int answer(String question, int[] range){
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.answer(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Out of menu range");
            } catch (NumberFormatException e) {
                System.out.println("Please enter validate data");
            }
        } while (invalid);
        return value;
    }
}
