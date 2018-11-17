package ru.job4j.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**
     * Удаляет дубликаты массива.
     * @param array
     * @return
     */
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String chek = array[i];
            for (int j = 1; j < array.length - 1; j++) {
                if (chek == array[j]) {
                    String swapValue = array[j];
                    array[j] = array[array.length - 1];
                    array[array.length - 1] = swapValue;
                    array = Arrays.copyOf(array, array.length - 1);
                    break;
                }
            }
        }
        return array;
    }
}
