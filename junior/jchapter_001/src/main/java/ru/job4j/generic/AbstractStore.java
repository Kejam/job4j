package ru.job4j.generic;

public abstract class AbstractStore<T> implements Store {
    private final SimpleArray<Base> simpleArray;

    protected AbstractStore(SimpleArray<Base> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(Base model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        simpleArray.set(Integer.parseInt(id), model);
        if (simpleArray.get(Integer.parseInt(id)).equals(model)) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        Base base = simpleArray.get(Integer.parseInt(id));
        simpleArray.delete(Integer.parseInt(id));
        if (base != simpleArray.get(Integer.parseInt(id))) {
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        return simpleArray.get(Integer.parseInt(id));
    }
}
