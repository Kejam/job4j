package ru.job4j.foods.food;

public class Meal extends Food {
    private String kindOfMeat;
    public Meal(String name, String expaireDate, String createDate, String price, String disscount, String kindOfMeat) {
        super(name, expaireDate, createDate, price, disscount);
        this.kindOfMeat = kindOfMeat;
    }

    @Override
    public String toString() {
        return "Meal{" + "kindOfMeat='" + kindOfMeat + '\'' + '}' + super.toString();
    }
}
