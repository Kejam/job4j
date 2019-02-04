package ru.job4j.carStrorage.Car;

import java.util.Objects;

public class Transmission {
    private int id;
    private String name;

    public Transmission() {
    }

    public Transmission(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transmission transmission = (Transmission) o;
        return id == transmission.id &&
                Objects.equals(name, transmission.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Transmission{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
