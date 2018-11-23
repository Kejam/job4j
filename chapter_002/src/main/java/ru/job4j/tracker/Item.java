package ru.job4j.tracker;

import java.util.Arrays;
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
    /**
     *
     */
    public Item() {
    }
    private String[] comments;
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
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public String[] getComments() {
        return comments;
    }
    public void setComments(String[] comments) {
        this.comments = comments;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Item{"
                + "name='"
                + name + '\''
                + ", desc='"
                + desc + '\''
                + ", id='"
                + id + '\''
                + ", time="
                + time
                +
                ", comments="
                + Arrays.toString(comments)
                + '}';
    }
}
