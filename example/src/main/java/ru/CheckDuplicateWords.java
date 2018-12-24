package ru;

public class CheckDuplicateWords {


    public boolean check(char[] wordOne,char[] wordTwo) {
        boolean result = true;
        if(wordOne.length != wordTwo.length) {
            result = false;
        }
        for (int i = 0; i < wordOne.length; i++) {
            if (wordOne[i] != wordTwo[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
