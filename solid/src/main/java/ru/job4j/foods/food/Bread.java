package ru.job4j.foods.food;

public class Bread extends Food {
    private String kindOfBread;
    public Bread(String name, String expaireDate, String createDate, String price, String disscount, String kindOfBread) {
        super(name, expaireDate, createDate, price, disscount);
        this.kindOfBread = kindOfBread;
    }

    @Override
    public String toString() {
        return "Bread{" + "kindOfBread='" + kindOfBread + '\'' + '}' + super.toString();
    }
}
