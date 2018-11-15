package ru.job4j.loop;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Cчитает факторил.
     * @param value Число до которого нужно посчитать факториал.
     * @return
     */
    int add(int value) {
        int result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }
}
