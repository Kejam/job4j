package ru.job4j;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCash<K, V> {
    private final Map<K, SoftReference<V>> hash = new HashMap<>();

    private void put(K key, V value){
        hash.put(key, (SoftReference<V>) value);
    }

    V get(K key) {
        V value;
        SoftReference<V> softReference = hash.get(key);
        if (softReference == null) {
            value = getData(key);
            this.put(key, value);
        } else {
            value = softReference.get();
        }

        return value;
    }

    abstract V getData(K key);
}
