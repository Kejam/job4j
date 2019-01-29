package ru.job4j.foods;

import ru.job4j.foods.food.Food;
import ru.job4j.foods.storage.Shop;
import ru.job4j.foods.storage.Trash;
import ru.job4j.foods.storage.Warehouse;

import java.util.Date;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version 0.01
 * This class implements control quality for products and then give them in storage.
 */
public class ControllQuality {
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    /**
     * Default constructor.
     * @param warehouse
     * @param shop
     * @param trash
     */
    public ControllQuality(Warehouse warehouse, Shop shop, Trash trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void transferTo(Food food) {
        int precent = percentOfQuality(food);
        if (precent < 25) {
            warehouse.add(food);
        }
        if (precent > 25 && precent < 75) {
            shop.add(food);
        }
        if (precent > 75) {
            trash.add(food);
        }
    }

    public int percentOfQuality(Food food) {
        int result = -1;
        int end = endOfQulaity(food);
        int quality = valueOfDay(food);
        int dayOfPrecent = Math.round(100/quality);
        if (end > 0) {
            result = (quality - end) * dayOfPrecent;
        }
        return result;
    }

    public int valueOfDay(Food food) {
        long create = Long.parseLong(food.getCreateDate());
        long expaire = Long.parseLong(food.getExpaireDate());
        return (int) (expaire - create) / (24 * 60 * 60 * 1000);
    }

    public int endOfQulaity(Food food) {
        return Math.round(
                (Long.parseLong(food.getExpaireDate()) - System.currentTimeMillis()) / (24 * 60 * 60 * 1000)
        );
    }
}
