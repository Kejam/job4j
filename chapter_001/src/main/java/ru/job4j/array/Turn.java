package ru.job4j.array;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**
     * Переворачивает массив.
     * @param array Исходный массив.
     * @return
     */
    public int[] back(int[] array) {
        int l = array.length;
        for (int i = 0; i < l / 2; i++) {
            int tempValue = array[l - i - 1];
            array[l - i - 1] = array[i];
            array[i] = tempValue;
        }
        return array;
    }
}
