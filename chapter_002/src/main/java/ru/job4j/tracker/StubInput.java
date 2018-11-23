package ru.job4j.tracker;
/** @author Aleksey Prozorov (kejamkwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например. Если пользователь
     * хочет выбрать добавление новой заявки ему нужно ввести:
     * 0 - выбор пункта меня "добавить новую заявку".
     * name - имя заявки
     * desc - описание заявки
     * y - выйти из трекера.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     * При каждом вызове надо передвинуть указатель на новое число.
     */
    private int position;
    public StubInput(final String[] value) {
        this.value = value;
    }
    /**
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и 
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String answer(String question) {
        return this.value[this.position++];
    }

    @Override
    public int answer(String question, int[] range) {
        return 0;
    }
}