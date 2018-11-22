package ru.job4j.strategy;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(" ** ");
        sb.append("****");
        return sb.toString();
    }
}
