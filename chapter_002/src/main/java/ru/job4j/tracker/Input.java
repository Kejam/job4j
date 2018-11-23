package ru.job4j.tracker;
/** @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public interface Input {
    /**
     * Input value.
     * @param question
     * @return
     */
    String answer(String question);
    /**
     * @param question
     * @param range
     * @return
     */
    int answer(String question, int[] range);
}
