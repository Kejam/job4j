package ru.job4j.condition;

/**
 * @author Prozorov Aleksey (kejamwork@mail.ru).
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    /**
     * Конструктор класса с x и y.
     * @param x - x.
     * @param y - y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Method echo.
     * @param that Point.
     * @return distance.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}
