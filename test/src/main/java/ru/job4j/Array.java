package ru.job4j;
/**
 *  Array Merge Two Massive
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 10.20.2018
 *  @version 1
 */
public class Array {
    public int[] mergeTwoArray(int[] arrayOne, int[] arrayTwo) {
        int[] array = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0, k = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            if (arrayOne[i] < arrayTwo[j]) {
                array[k] = arrayOne[i];
                i++;
            }
            else {
                array[k] = arrayTwo[j];
                j++;
            }
            k++;
        }
        while (i < arrayOne.length) {
            array[k] = arrayOne[i];
            i++;
            k++;
        }
        while (j < arrayTwo.length) {
            array[k] = arrayTwo[j];
            j++;
            k++;
        }
        return array;
    }
}
