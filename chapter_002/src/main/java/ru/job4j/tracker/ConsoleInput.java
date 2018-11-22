package ru.job4j.tracker;
/** @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
import java.util.Scanner;
public class ConsoleInput implements Input {
    /**
     * Input value.
     * @param answer
     * @return
     */
    public String answer(String answer) {
        Scanner scanner = new Scanner(System.in);
        answer = scanner.nextLine();
        return answer;
    }
}
