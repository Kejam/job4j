package ru.job4j.foods.storage;

import ru.job4j.foods.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash {
    private List<Food> storage = new ArrayList<>();

    public void add(Food food) {
        storage.add(food);
    }

    public List<Food> getStorage() {
        return storage;
    }
}
