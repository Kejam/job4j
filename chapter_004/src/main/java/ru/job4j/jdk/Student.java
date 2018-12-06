package ru.job4j.jdk;

import java.util.Comparator;
import java.util.Objects;


public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", scope=" + scope + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
