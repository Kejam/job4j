package ru.job4j.map;

public class AssociativeArray<K, V> {
    private int index = 0;
    private Object[] ar;

    public AssociativeArray(int size) {
        ar = new Object[size];
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        if (checkKey(key)) {
            for(java.lang.Object o1: ar[searchIndex(key)].getValue()) {
                if (o1.equals(value)) {
                    o1 = value;
                    break;
                }
            }
            ar[searchIndex(key)].addValue(value);
        }
        if (!checkKey(key)) {
            ar[index++] = new Object(key, value);
        }
        return result;
    }

    public V get(K key) {
        return (V) ar[searchIndex(key)].getValue();
    }

    public boolean delete(K key) {
        boolean result = false;
        if (checkKey(key)) {
            System.arraycopy(ar, searchIndex(key) - 1, ar, searchIndex(key), ar.length);
            result = true;
        }
        return result;
    }

    private boolean checkKey(K key) {
        boolean result = false;
        for(Object o: ar) {
            if (o.getKey().equals(key)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int searchIndex(K key) {
        int result = -1;
        for(int i = 0; i < ar.length; i++) {
            if (ar[i].getKey().equals(key)) {
                result = i;
            }
        }
        return result;
    }
}
