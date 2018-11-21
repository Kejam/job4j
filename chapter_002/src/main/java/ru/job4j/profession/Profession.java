package ru.job4j.profession;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 12.11.2018
 *  @version 1
 */
public class Profession {
    private String name;
    /**
     * Конструктор с именеме.
     * @param name
     */
    public Profession(String name) {
        this.name = name;
    }
    /**
     *  Получаем имя.
     * @return
     */
    public String getName() {
        return name;
    }
}
