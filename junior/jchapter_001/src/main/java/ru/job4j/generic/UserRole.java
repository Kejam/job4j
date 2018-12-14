package ru.job4j.generic;

public class UserRole<Role extends Base> extends AbstractStore<Role> {
    protected UserRole(SimpleArray<Role> simpleArray) {
        super(simpleArray);
    }
}
