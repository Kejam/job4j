package ru.job4j.profession;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 12.11.2018
 *  @version 1
 */
public class Doctor extends Profession {
    /**
     * Конструктор с именем.
     * @param name
     */
    public Doctor(String name) {
        super(name);
    }
    /**
     * Получаем диагноз пациента.
     * @param pacient Объект пациент.
     * @return Болезнь пациента.
     */
    public String diagnose(Pacient pacient) {
        return pacient.getDiagnose();
    }
}
