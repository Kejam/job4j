package ru.job4j.profession;
/**
 *  Calculate решение задачи
 *  @author Aleksey Prozorov (kejamwork@mail.ru)
 *  @since 12.11.2018
 *  @version 1
 */
public class Pacient {
    private String name;
    private String age;
    private String diagnose;
    /**
     * Constructor with name, age, diagnose.
     * @param name
     * @param age
     * @param diagnose
     */
    public Pacient(String name, String age, String diagnose) {
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
    }

    /**
     * Return diagnose.
     * @return
     */
    public String getDiagnose() {
        return diagnose;
    }
}
