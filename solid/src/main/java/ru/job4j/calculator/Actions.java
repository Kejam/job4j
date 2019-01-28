package ru.job4j.calculator;
/*
* Калькулятор с простыми действиями.
*/

public class Actions {
    private double result;
    /**
     * Method add.
     * @param first first param.
     * @param second second param .
     */
    public void add(double first, double second) {
        this.result = first + second;
    }
    /**
     * Method subtract.
     * @param first first param.
     * @param second second param .
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }
    /**
     * Method div.
     * @param first first param.
     * @param second second param .
     */
    public void div(double first, double second) {
        this.result = first / second;
    }
    /**
     * Method multiple.
     * @param first first param.
     * @param second second param .
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
     * Method getResult.
     * @return result.
     */
    public double getResult() {
        return this.result;
    }
}
