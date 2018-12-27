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
}
