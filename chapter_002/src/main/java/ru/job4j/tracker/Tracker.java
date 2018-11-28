package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/** @author Aleksey Prozorov (kejamkwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<Item>();
    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        this.items.add(item);
        return item;
    }
    /**
     * Replace item.
     * @param id
     * @param item
     */
    public boolean replace(int id, Item item) {
        boolean result = false;
        items.set(id, item);
        if (items.contains(item)) {
            result = true;
        }
        return result;
    }
    /**
     * Delete item.
     * @param id
     */
    public boolean delete(int id) {
        boolean result = false;
        items.remove(id);
        return result;
    }
    /**
     * Return all items.
     * @return
     */
    public List<Item> findAll() {
        return items;
    }
    /**
     * Find by name.
     * @param key
     * @return
     */
    public List<Item> findByName(String key) {
        List<Item> copyItem =  new ArrayList<Item>();
        for (Item item1: items) {
            if (item1.toString().contains(key)) {
                copyItem.add(item1);
            }
        }
        return copyItem;
    }
    /**
     * Find by id.
     * @param id
     * @return
     */
    public Item findById(int id) {
        Item item = items.get(id);
        return item;
    }
}
