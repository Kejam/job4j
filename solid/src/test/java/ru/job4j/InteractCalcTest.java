package ru.job4j;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.calculator.Actions;
import ru.job4j.calculator.ActionsEng;
import ru.job4j.calculator.InteractCalc;
import ru.job4j.calculator.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class InteractCalcTest {
    private InteractCalc calc;
    @Before
    public void setUp() {
        calc = new InteractCalc(new User(), new ActionsEng());
    }
    @Test
    public void whenSaveParametr() {

    }
    @Test
    public void whenNotSaveParametr() {

    }
    @Test
    public void whenFirstAction() {

    }
}
