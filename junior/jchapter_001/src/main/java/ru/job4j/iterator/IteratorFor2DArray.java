package ru.job4j.iterator;
import java.util.Iterator;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class sequentially return values.
 * This class implements Iterator for 2D array.
 */
public class IteratorFor2DArray implements Iterator{
    private final int[][] array;
    private int indexVertical = 0;
    private int indexHorizontal = 0;
    public IteratorFor2DArray(final int[][] array) {
        this.array = array;
    }
    /**
     * Compare to length index vertical and index horizontal if any index more then return false else return true.
     * @return
     */
    @Override
    public boolean hasNext() {
        return (indexHorizontal < array[indexVertical].length && indexVertical < array.length);
    }
    /**
     * If hasNext return true then return object[i][j++] and check that params is true else don't return object.
     * @return
     */
    @Override
    public Object next() {
        Object object = null;
        if (hasNext()) {
            object = array[indexVertical][indexHorizontal++];
            if (indexHorizontal == array[indexVertical].length && indexVertical < array.length - 1) {
                indexHorizontal = 0;
                indexVertical++;
            }
        }
        return object;
    }
}
