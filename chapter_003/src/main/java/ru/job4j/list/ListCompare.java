package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int value = 0;
        char[] cL = left.toCharArray();
        char[] cR = right.toCharArray();
        if (cL.length > cR.length) {
            value = cL.length - cR.length;
        }
        if (cL.length < cR.length) {
            value = cR.length - cL.length ;
        }
        return value;
    }
}
