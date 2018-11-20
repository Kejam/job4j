package ru.job4j;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 10.20.2018
 *  @version 1
 */
public class Array {
    public int[] mergeTwoArray(int[] arrayOne, int[] arrayTwo) {
        int[] array = new int[arrayOne.length + arrayTwo.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            if (arrayOne[i] > arrayTwo[j]) {
                array[k] = arrayOne[i];
                i++;
                break;
            }
            if (arrayOne[i] == arrayTwo[j]) {
                array[k] = arrayOne[i];
                k++;
                array[k] = arrayTwo[j];
                i++;
                j++;
                break;
            }
            if (arrayTwo[j] > arrayOne[i]) {
                array[k] = arrayTwo[j];
                j++;
                break;
            }
        }
        return array;
    }
}
