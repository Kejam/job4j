package ru.job4j.todolist.logic.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Item {
    private int id;
    private String description;
    private Timestamp date;
    private boolean done;

    public Item(int id, String description, Timestamp date, boolean done) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public Item(String description, Timestamp date, boolean done) {
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public Item() {
    }


    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", description='" + description + '\'' + ", date=" + date + ", done=" + done + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && done == item.done && Objects.equals(description, item.description) && Objects.equals(date, item.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, date, done);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
