package ru.job4j.logic;

import java.util.Objects;

public class Man {
    private String id;
    private String name;
    private String surname;
    private String sex;
    private String description;

    public Man(String id, String name, String surname, String sex, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return id == man.id &&
                Objects.equals(name, man.name) &&
                Objects.equals(surname, man.surname) &&
                Objects.equals(sex, man.sex) &&
                Objects.equals(description, man.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, sex, description);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
