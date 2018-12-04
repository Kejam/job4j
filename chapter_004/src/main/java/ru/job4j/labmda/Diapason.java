package ru.job4j.labmda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new LinkedList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply(d));
        }
        return result;
    }

    public static void main(String[] args) {
        Diapason diapason = new Diapason();
        diapason.diapason(1,3, (d) -> d * d);
    }
}
