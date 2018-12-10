package ru.job4j.iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * This class sequentially return values.
 * This class implements Iterator for 2D array.
 */
public class IteratorFor2DArray implements Iterator<Integer>{
    private final int[][] array;
    private int iV = 0;
    private int iH = 0;
    public IteratorFor2DArray(final int[][] array) {
        this.array = array;
    }
    /**
     * Compare to length index vertical and index horizontal if any index more then return false else return true.
     * @return
     */
    @Override
    public boolean hasNext() {
        return (iH < array[iV].length && iV < array.length);
    }
    /**
     * If hasNext return true then return object[i][j++] and check that params is true else don't return object.
     * @return
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Integer integer = array[iV][iH++];
        if (iH == array[iV].length && iV < array.length - 1) {
            iH = 0;
            iV++;
        }
        return integer;
    }
}
