package ru.job4j.list;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private String id;
    private String city;
    private int age;

    public String getId() {
        return id;
    }

    public User(String name, String id, String city, int age) {
        this.name = name;
        this.id = id;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(id, user.id) && Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, city, age);
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", id='" + id + '\'' + ", city='" + city + '\'' + ", age=" + age + '}';
    }

    @Override public int compareTo(User o) {
        int value = 0;
        if (this.getAge() > o.getAge()) {
            value = -1;
        }
        if (this.getAge() < o.getAge()) {
            value = 1;
        }
        return value;
    }
}
