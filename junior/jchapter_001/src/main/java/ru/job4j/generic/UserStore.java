package ru.job4j.generic;

public class UserStore<Storre extends Base> extends AbstractStore<Storre> {
    protected UserStore(SimpleArray<Storre> simpleArray) {
        super(simpleArray);
    }
}
