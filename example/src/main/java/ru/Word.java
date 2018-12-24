package ru;

import java.util.HashSet;

public class Word {
    public boolean check(char[] word) {
        boolean result = false;
        HashSet<Character> list = new HashSet<>();
        for(int i = 0; i < word.length; i++) {
            list.add(word[i]);
        }
        if (list.size() / word.length == 2) {
            result = true;
        }
        return result;
    }
}
