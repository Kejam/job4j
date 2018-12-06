package ru.job4j.jdk;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentTest {
    @Test
    public void whenThreeStudentThenTwo() {
        Students student = new Students();
        student.add("Ivan Prozorov", 23);
        student.add("Alex Prozorov", 33);
        student.add("Aleksey Prozorov", 13);
        List<Student> actual = student.levelOf(31);
        List<Student> expect = Arrays.asList(
                new Student("Alex Prozorov", 33)
        );
        assertThat(actual, is(expect));
    }
}
