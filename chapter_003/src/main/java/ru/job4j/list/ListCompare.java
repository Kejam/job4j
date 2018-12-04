package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] cL = left.toCharArray();
        char[] cR = right.toCharArray();
        int min = Math.min(cL.length, cR.length);
        int result = 0;
        for (int i = 0; i < min; i++) {
            result = Character.compare(cL[i], cR[i]);
            if (result != 0) {
                break;
            }
        }
        return result != 0 ? result : Integer.compare(left.length(), right.length());
    }
}
