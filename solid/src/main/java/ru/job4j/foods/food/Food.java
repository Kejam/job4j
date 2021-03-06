package ru.job4j.foods.food;

import java.util.Date;

/**
 *  This class implements simple object of foods.
 *  @author Prozorov Aleksey (kejamwork@mail.ru).
 *  @version 0.1
 */
public class Food {
    private final String name;
    private final String expaireDate;
    private final String createDate;
    private final String price;
    private final String disscount;

    public String getName() {
        return name;
    }

    public String getExpaireDate() {
        return expaireDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getPrice() {
        return price;
    }

    public String getDisscount() {
        return disscount;
    }

    /**
     * Default constructor.
     * @param name
     * @param expaireDate
     * @param createDate
     * @param price
     * @param disscount
     */
    public Food(String name, String expaireDate, String createDate, String price, String disscount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.disscount = disscount;
    }

    @Override
    public String toString() {
        return "Food{" + "name='" + name + '\'' + ", expaireDate='" + expaireDate + '\'' + ", createDate='" + createDate + '\'' + ", price='" + price + '\'' + ", disscount='" + disscount + '\'' + '}';
    }
}
