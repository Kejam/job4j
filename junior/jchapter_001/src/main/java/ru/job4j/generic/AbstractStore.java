package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> simpleArray;

    protected AbstractStore(SimpleArray<T> simpleArray) {
        this.simpleArray = simpleArray;
    }

    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (simpleArray.get(i) != null && simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                result = true;
                break;
            }
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
    public T findById(String id) {
        return (T) simpleArray.get(Integer.parseInt(id));
    }
}
