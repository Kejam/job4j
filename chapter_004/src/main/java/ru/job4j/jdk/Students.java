package ru.job4j.jdk;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Students {
    private List<Student> students = new ArrayList<>();
    public void add(String name, int scope) {
        Student student = new Student(name, scope);
        students.add(student);
    }
    List<Student> levelOf(int bound) {
        List<Student> students1 = students
                .stream()
                .sorted(Comparator.comparing(Student::getScope))
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope() >= bound)
                .collect(Collectors.toList());
        return students1;
    }
}
