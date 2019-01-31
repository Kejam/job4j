package ru.job4j.tdd;

import java.util.HashMap;

/**
 * Interface for simple generation.
 * @author kejamwork@mail.ur
 * @version 0.01
 */
public interface SimpleGeneration {
    /**
     * This method receives String @message and HashMap @data then changes ${...} to value of HashMap where first value is key of data and other values is values of data.
     * @param message
     * @param data
     * @return
     */
    String generation(String message, HashMap<String, String> data);
}
