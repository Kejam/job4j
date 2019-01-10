package ru;

public class Man {
    private String name;
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void say() {
        System.out.println("Сделай мне массаж!");
    }
}
