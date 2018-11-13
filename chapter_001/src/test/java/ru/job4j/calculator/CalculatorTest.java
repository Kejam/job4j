package ru.job4j.calculator;

import org.junit.Test;
import ru.job4j.calculator.Calculator;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultipleTwoMulTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2d, 2d);
        double result = calc.getResult();
        double expected = 4d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivideSixDivThree() {
        Calculator calc = new Calculator();
        calc.div(6d, 3d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubSixSubThree() {
        Calculator calc = new Calculator();
        calc.substract(6d, 3d);
        double result = calc.getResult();
        double expected = 3d;
        assertThat(result, is(expected));
    }
}