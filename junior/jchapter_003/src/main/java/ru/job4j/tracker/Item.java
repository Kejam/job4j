package ru.job4j.tracker;

import java.util.Objects;

/**
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String name;
    private String desc;
    private String id;
    private long time;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return time == item.time && Objects.equals(name, item.name) && Objects.equals(desc, item.desc) && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, id, time);
    }

    /**
     *
     * @param name
     * @param desc
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.time = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     *
     */

    @Override
    public String toString() {
        return "Item{" + "name='" + name + '\'' + ", desc='" + desc + '\'' + ", id='" + id + '\'' + ", time=" + time + '}';
    }
}
