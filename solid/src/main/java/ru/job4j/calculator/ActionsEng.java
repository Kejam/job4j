package ru.job4j.calculator;

/**
 * This class implements action for engineer action.
 * @author Prozorov Aleksey (kejamwork@mail.ru).
 * @version 0.1
 */
public class ActionsEng extends Actions {
    private double result;

    public ActionsEng() {
        super();
    }

    public void exponentiation(double first, double second) {
        this.result = Math.pow(first, second);
    }

    public double getResult() {
        return result;
    }
}
