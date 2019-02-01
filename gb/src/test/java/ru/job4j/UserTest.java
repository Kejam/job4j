package ru.job4j;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;



public class UserTest  {


    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    @Test
    public void whenSerial() {
        User.test();
    }

    @Test
    public void whenParallel() {
        User.test();
    }

    @Test
    public void whenCMS() {
        User.test();
    }

    @Test
    public void whenG1() {
        User.test();
    }
}