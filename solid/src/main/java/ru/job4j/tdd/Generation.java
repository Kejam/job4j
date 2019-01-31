package ru.job4j.tdd;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements simple generation.
 * @author kejamwork@mail.ur
 * @version 0.01
 */
public class Generation implements SimpleGeneration {
    /**
     * This method receives String @message and HashMap @data then changes ${...} to value of HashMap where first value is key of data and other values is values of data.
     * Also the method check that @data is not null, @data contains value more zero, @data size equals @checkValue, @message contains special char.
     * @param message
     * @param data
     * @return
     */
    @Override
    public String generation(String message, HashMap<String, String> data) {
        int valueSpecialChar = checkValue(message);
        String result = "";
        if(data == null) {
            result = "HashMap equals null";
        } else if (data.size() == 0) {
            result = "HashMap don't contains anything!";
        } else if (valueSpecialChar != 0 && valueSpecialChar != data.size()) {
            result = "Message hasn't special char or HashMap has many keys!";
        } else {
            for (Map.Entry<String, String> entry: data.entrySet()) {
                String specialChar = findSpecialSymbol(result);
                while (result.contains(specialChar)) {
                    result = result.replace("", entry.getKey());
                }
                specialChar = findSpecialSymbol(result);
                while (result.contains(specialChar)) {
                    result = result.replace("", entry.getValue());
                }
            }
        }
        return result;
    }

    /**
     * Finds and returns specialChar
     * @param message
     * @return
     */
    private String findSpecialSymbol(String message) {
        String result = message;
        int first = message.indexOf('$');
        int second = message.indexOf('}', first);
        return result.substring(first, second);
    }


    /**
     * Count special value then returns value.
     * @param message
     * @return
     */
    private int checkValue(String message) {
        int result = 0;
        for (char s: message.toCharArray()) {
            if (s == '$') {
                result++;
            }
        }
        return result;
    }
}
