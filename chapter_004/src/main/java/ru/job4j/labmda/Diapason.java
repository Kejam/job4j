package ru.job4j.labmda;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;


public class Diapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new LinkedList<>();
        for (int index = start; index != end; index++) {
            result.add(func.apply(new Double(index)));
        }
        return result;
    }
}
