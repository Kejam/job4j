package ru.job4j.array;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Check {
    /**
     * Проверяем одинаков ли массив.
     * @param data Исходный массив.
     * @return
     */
    public boolean mono(boolean[] data) {
        int check = 0;
        for (boolean x: data) {
            if (data[0] == x) {
                check++;
            }
        }
        return check == data.length;
    }
}
