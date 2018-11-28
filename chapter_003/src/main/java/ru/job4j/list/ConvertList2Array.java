package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = rows;
        int index = 0;
        int[][] array = new int[rows][cells];
        for (int i = 0; i < rows; i++) {
            for (int y = 0; y < cells; y++) {
                if (list.size() - 1 >= index) {
                    array[i][y] = list.get(index++);
                }
            }
        }
        return array;
    }
}