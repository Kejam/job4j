package ru.job4j.list;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private String id;
    private String city;

    public String getId() {
        return id;
    }

    public User(String name, String id, String city) {
        this.name = name;
        this.id = id;
        this.city = city;
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
        return Objects.equals(name, user.name) && Objects.equals(id, user.id) && Objects.equals(city, user.city);
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

    @Override
    public int hashCode() {
        return Objects.hash(name, id, city);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='"
                + name
                + '\''
                + ", age='"
                + id
                + '\''
                + ", city='"
                + city
                + '\''
                + '}';
    }

    @Override public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }
}
