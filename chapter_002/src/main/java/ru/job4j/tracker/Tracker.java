package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        item.setId(generateId());
        return item;
    }
    /**
     * Replace item.
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item item1: items) {
            if (item1.getId().equals(id)) {
                item.setId(item1.getId());
                items.set(items.indexOf(item1), item);
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Delete item.
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        for (Item item1: items) {
            if (item1.getId().equals(id)) {
                items.remove(item1);
                result = true;
                break;
            }
        }
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
        List<Item> copyItem =  items
                .stream()
                .filter(
                        item -> item.toString().equals(key)
                )
                .collect(Collectors.toList());
        return copyItem;
    }
    /**
     * Find by id.
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        List<Item> items1 = items
                .stream()
                .filter(item -> item.getId().equals(id))
                .collect(Collectors.toList());
        result = items1.get(0);
        return result;
    }
    private String generateId() {
        Random random = new Random();
        String id = String.valueOf(System.currentTimeMillis() + random.nextInt(100));
        return  id;
    }
}
