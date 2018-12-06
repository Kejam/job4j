package ru.job4j.search;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 27.11.2018
 *  @version 1
 */
import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {
    private List<Person> persons = new ArrayList<Person>();
    /**
     *
     * @param person
     */
    public void add(Person person) {
        this.persons.add(person);
    }
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {

        List<Person> result = new ArrayList<>();
        for (var person: persons) {
            var temp = String.format("%s%s%s%s", person.getAddress(), person.getName(), person.getPhone(), person.getSurname());
            if (temp.contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}