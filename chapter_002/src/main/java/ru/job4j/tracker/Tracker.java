package ru.job4j.tracker;
import java.util.Arrays;
import java.util.Random;
/** @author Aleksey Prozorov (kejamkwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random random = new Random();
        String id = String.valueOf(random.nextInt(100));
        return id;
    }
    /**
     * Replace item.
     * @param id
     * @param item
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }
    /** Delete item.
     * dsfsd
     * @param id
     * @param item
     */
    public void delete(String id, Item item) {
        for (int i = 0; i < position; i++) {
            if (items[i].equals(item)) {
                item = items[0];
                items[0] = items[i];
                items[i] = item;
                System.arraycopy(items, 1, items, 0, position);
                break;
            }
        }
    }
    /**
     * Return all items.
     * @return
     */
    public Item[] findAll() {
        Item[] copyItem = new Item[position + 1];
        copyItem = Arrays.copyOf(items, position);
        return copyItem;
    }
    /**
     * Find by name.
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        Item[] copyItem =  new Item[100];
        int count = 0;
        for (int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                copyItem[count++] = items[i];
            }
        }
        copyItem = Arrays.copyOf(copyItem, 99 - count);
        return copyItem;
    }
    /**
     * Find by id.
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item item = new Item();
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
            }
        }
        return (item.equals(null)) ? null : item;
    }
}
