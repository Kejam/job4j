package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int value = 0;
        char[] cL = left.toCharArray();
        char[] cR = right.toCharArray();
        int max = Math.max(cL.length, cR.length);
        int i = 0;
        while (max < i) {
           value = 1;
        }
        return value;
    }
}
