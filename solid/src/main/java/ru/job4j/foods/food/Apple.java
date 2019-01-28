package ru.job4j.foods.food;

public class Apple extends Food {
    public Apple(String name, String expaireDate, String createDate, String price, String disscount) {
        super(name, expaireDate, createDate, price, disscount);
    }

    @Override
    public String toString() {
        return "Apple{}" + super.toString();
    }
}
