package ru.job4j.nba;

import java.util.concurrent.ConcurrentHashMap;

public class BaseStorage {
    private ConcurrentHashMap<Integer, Base> list = new ConcurrentHashMap<>();

    public void add(Base model) {
        while (list.size() > 0) {
            list.put(model.getId(), model);
            notify();
        }
    }
    public void update(Base model) {
        list.computeIfPresent(model.getId(),
                (integer, base) -> {
                    if (model.getVersion() != base.getVersion()) {
                        throw new OptimisticException("Error version");
                    }
                    base.upVersion();
                    return base;
                }
        );
    }

    public void delete(Base model) throws InterruptedException {
        if (list.size() == 0) {
            wait();
        }
        if (list.containsKey(model.getId())) {
            list.remove(model.getId());
        }
    }
}
