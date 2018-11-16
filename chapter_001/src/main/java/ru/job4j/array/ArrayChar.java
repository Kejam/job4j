package ru.job4j.array;
/**
 * @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        char[] value = prefix.toCharArray();
        int check = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (data[i] == value[i]) {
                check++;
            }
        }
        return check == value.length;

    }
}
