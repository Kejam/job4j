package ru.job4j.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GenerationTest {
    private Generation generation;

    @Before
    public void setUp() {
        generation = new Generation();
    }
    @Test
    public void whenNullThenReturnEcxeption() {
        String message = "I am a ${name}, Who are ${subject}? ";
        HashMap<String, String> data = null;
        String expect = "HashMap equals null";

        String actual = generation.generation(message, data);

        Assert.assertThat(actual, is(expect));

    }

    @Test
    public void whenHashMapDontContainsElements() {
        String message = "I am a ${name}, Who are ${subject}? ";
        HashMap<String, String> data = new HashMap<>();
        String expect = "HashMap don't contains anything!";

        String actual = generation.generation(message, data);

        Assert.assertThat(actual, is(expect));

    }

    @Test
    public void whenMessageDontContainsSpecialChar() {
        String message = "I am a ${name}, Who are ${subject}? ";
        HashMap<String, String> data = new HashMap<>();
        data.put("Alex", "I'm a student and work im Mcdonald's");
        String expect = "Message hasn't special char or HashMap has many keys!";

        String actual = generation.generation(message, data);

        Assert.assertThat(actual, is(expect));

    }

    @Test
    public void whenHashMapContainsMoreElements() {
        String message = "I am a ${name}, Who are {subject}? ";
        HashMap<String, String> data = new HashMap<>();
        data.put("Alex", "I'm a student and work im Mcdonald's");
        data.put("Kate", "I'm a cat");
        String expect = "Message hasn't special char or HashMap has many keys!";

        String actual = generation.generation(message, data);

        Assert.assertThat(actual, is(expect));

    }



    @Test
    public void whenDataHasTwoValueThenReturnTwoMessage() {
        String message = "I am a ${name}, Who are ${subject}?";
        HashMap<String, String> data = new HashMap<>();
        data.put("Alex", "I'm a student and work im Mcdonald's");
        data.put("Kate", "I'm a cat");
        String expect = "I am a Alex, Who are I'm a student and work im Mcdonald's?\n"
                + "I am a Kate, Who are I'm a cat";

        String actual = generation.generation(message, data);

        Assert.assertThat(actual, is(expect));
    }

}