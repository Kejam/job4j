package ru.job4j.iterator;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorConvert {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Integer next() {
                Integer integer = null;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return integer;
            }
            Iterator it1() {
                Iterator iterator  = it.next();
                return iterator  = it.next();
            }
        };
    }
}
