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
        int unique = array.length;
        for (int i = 0; i < unique; i++) {
            for (int j = i + 1; j < unique; j++) {
                if (array[i].equals(array[j])) {
                    array[j--] = array[--unique];
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
