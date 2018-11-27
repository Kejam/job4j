package ru.job4j.coffeMachine;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 27.11.2018
 *  @version 1
 */
import java.util.Arrays;
/**
 *  CoffeMachine
 */
public class CoffeMachine {
    private int position = 0;
    private int values[] = {1, 2, 5, 10};
    /**
     * Return array with money.
     * @param value
     * @param price
     * @return
     */
    int[] changes(int value, int price) {
        int[] answer = new int[10];
        value -= price;
        for(int i = values.length-1; i >= 0; i--) {
            while (value >= values[i]) {
                answer[position++] = values[i];
                value -= values[i];
            }
        }
        answer = Arrays.copyOf(answer, position);
        return answer;
    }
}
