package ru.job4j.tracker;
/** @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    /**
     * Input value.
     * @param question
     * @return
     */
    @Override
    public String answer(String question) {
        System.out.println(question);
        question = scanner.nextLine();
        return question;
    }

    @Override
    public int answer(String question, int[] range) throws MenuOutException, NumberFormatException {
        System.out.println(question);
        boolean validate = false;
        int key = Integer.valueOf(scanner.nextLine());
        for (int rang: range) {
            if (rang == key) {
                validate = true;
                break;
            }
        }
        if (!validate) {
            throw new MenuOutException("Out of menu range");
        }
        return key;
    }
}
