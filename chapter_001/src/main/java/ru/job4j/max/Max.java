package ru.job4j.max;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    private int first;
    private int second;
    /**
     * Сравнивает два числа и зовращает большее.
     * @param first Первое значение.
     * @param second Второе значение.
     * @return результат.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    /**
     * Сравнивает два числа и зовращает большее.
     * @param first Первое значение.
     * @param second Второе значение.
     * @param third Третье значение.
     * @return результат.
     */
    public int max(int first, int second, int third) {
        int result = max(first, second);
        result = max(result, third);
        return result;
    }
}
