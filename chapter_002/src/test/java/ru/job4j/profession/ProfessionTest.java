package test.java.ru.job4j.profession;

import main.java.ru.job4j.profession.Doctor;
import main.java.ru.job4j.profession.Engineer;
import main.java.ru.job4j.profession.Pacient;
import main.java.ru.job4j.profession.Teacher;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfessionTest {
    @Test
    public void whenPacientHasHeadacheThenHeadeache() {
        Doctor doctor = new Doctor("Alex");
        Pacient pacient = new Pacient("Alex","19","Headache");
        String actual = "Headache";
        String expect = doctor.Diagnose(pacient);
        assertThat(actual, is(expect));
    }
    @Test
    public void whenDoctorString() {
        Doctor doctor = new Doctor("Alex");
        String actual = doctor.getName();
        String expect = "Alex";
        assertThat(expect, is(actual));
    }
    @Test
    public void whenTeacherString() {
        Teacher teacher = new Teacher("Kate");
        String actual = teacher.getName();
        String expect = "Kate";
        assertThat(expect, is(actual));
    }
    @Test
    public void whenEngineerString() {
        Engineer engineer = new Engineer("Mark");
        String actual = engineer.getName();
        String expect = "Mark";
        assertThat(expect, is(actual));
    }

}
