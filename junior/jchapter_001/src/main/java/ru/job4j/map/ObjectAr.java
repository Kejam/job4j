package ru.job4j.map;

public class ObjectAr<K, V> {
    private K key;
    private V[] value = (V[]) new java.lang.Object[100]; // Не вовсем понял как сделать корректо, реализовавывать рост пока не буду, оставлю просто 100.
    private int index = 0;
    public ObjectAr(K key, V value) {
        this.key = key;
        this.value[index++] = value;
    }

    public void addValue(V value) {
        this.value[index++] = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V[] value) {
        this.value = value;
    }

    public V[] getValue() {
        return value;
    }
}
