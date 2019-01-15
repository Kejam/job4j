package ru;

import java.util.HashSet;

public class Word {
    public boolean check(char[] word) {
        boolean result = true;
        HashSet<Character> list = new HashSet<>();
        for (int i = 0; i < word.length; i++) {
            list.add(word[i]);
        }
        int actual = list.size() / word.length;
        if (actual != 2) {
            result = false;
        }
        return result;
    }
    public boolean contain(String wordIn, String containIn) {
        boolean result = false;
        char[] word = wordIn.toCharArray();
        char[] contain = containIn.toCharArray();
        int count = 0;
        if (word.length > contain.length) {
            for (int i = 0; i < word.length; i++) {
                if (word[i] == contain[count] && i + contain.length <= word.length) {
                    count++;
                } else {
                    count = 0;
                }
                if (count == contain.length) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
