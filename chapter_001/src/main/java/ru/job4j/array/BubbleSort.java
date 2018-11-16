package ru.job4j.array;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**
     *  Сортировка пузырьковым методом.
     * @param array Исходный массив.
     * @return
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[ j ];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }
}
