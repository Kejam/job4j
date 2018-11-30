package ru.job4j.list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] cL = left.toCharArray();
        char[] cR = right.toCharArray();
        int min = Math.min(cL.length, cR.length);
        int i = 0;
        while (min < i) {
            if(Character.compare(cL[i], cR[i]) != 0) {
                break;
            }
            i++;
        }
        if (i == 0) {
            i = Integer.compare(cL.length, cR.length);
        }
        return i;
    }
}
