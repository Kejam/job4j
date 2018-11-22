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
     * @param answer
     * @return
     */
    public String answer(String answer) {
        answer = scanner.nextLine();
        return answer;
    }
}
