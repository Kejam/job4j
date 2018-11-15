package ru.job4j.counter;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Counter {
    private int result;

    /**
     * @return Возвращает сложения четных чиселю.
     */
    int add() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}
