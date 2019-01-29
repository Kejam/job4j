package ru.job4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.foods.ControllQuality;
import ru.job4j.foods.food.Apple;
import ru.job4j.foods.food.Food;
import ru.job4j.foods.storage.Shop;
import ru.job4j.foods.storage.Trash;
import ru.job4j.foods.storage.Warehouse;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class QualityTest {
    private ControllQuality control;
    @Before
    public void setUp() {
        control = new ControllQuality(new Warehouse(), new Shop(), new Trash());
    }
    @Test
    public void whenCheckDate() {
        Food food = new Food("apple", "1548633600000", "1551312000000","100", "10");
        assertThat(control.valueOfDay(food), is(18));
    }
    @Test
    public void whenCheckEnd() {
        Food food = new Food("apple", "1548633600000", "1551312000000","100", "10");
        assertThat(control.endOfQulaity(food), is(29));
    }
    @Test
    public void whenPrecent() {
        Food food = new Food("apple", "1548633600000", "1551312000000","100", "10");
        assertThat(control.percentOfQuality(food), is(95));
    }
    @Test
    public void whenAdd() {
        Apple apple = new Apple("apple", "1548633600000", "1551312000000","100", "10");
        control.transferTo(apple);
        assertThat(control.getShop().getStorage().contains(apple), is(true));
    }
}
