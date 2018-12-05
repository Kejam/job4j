package ru.job4j.test;
/**
 * kejam.
 */

import java.util.ArrayList;
import java.util.Comparator;

/**
 *  Class for sorter String.
 */
public class Sort {
        /**
         *  List sort.
         */
    private ArrayList<String> sort = new ArrayList<>();

    /**
     *  Add element into collection.
     * @param name
     * @return
     */
    public boolean add(String name) {
        boolean result = false;
        if (name != null) {
            sort.add(name);
            result = true;
        }
        return result;
    }

    /**
     * String convert in array of char and equals by value.
     * @param
     * @return
     */
    public boolean sorter(int i) {
        boolean result = false;
        sort.sort(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        char[] cL = o1.toCharArray();
                        char[] cR = o2.toCharArray();
                        int min = Math.min(cL.length, cR.length);
                        int result = 0;
                           if (i == 0) {
                               //for (int i = 0; i < min; i++) {
                                   result = Character.compare(cL[i], cR[i]);
                                   if (result != 0) {
                                       break;
                                   }
                               }
                               return result != 0 ? result : Integer.compare(o1.length(), o2.length());
                           }
                           if (i == 1) {
                               for (int i = 0; i < min; i++) {
                                   result = Character.compare(cR[i], cL[i]);
                                   if (result != 0) {
                                       break;
                                   }
                               }
                               return result != 0 ? result : Integer.compare(o1.length(), o2.length());
                           }
                           return result;
                    }
                }
            );
        return result;
    }

    /**
     * Return all array.
     * @return
     */
    public ArrayList<String> getSort() {
        return sort;
    }
}
