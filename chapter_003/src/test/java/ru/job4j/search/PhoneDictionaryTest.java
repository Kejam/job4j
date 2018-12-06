package ru.job4j.search;

import org.junit.Test;
import ru.job4j.search.*;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDirectory();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")

        );
        phones.add(
                new Person("asdf", "Arsentev", "534872", "Bryansk")

        );
        phones.add(
                new Person("sdfsdf", "Arsentev", "534872", "Bryansk")

        );
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}