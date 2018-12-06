package ru.job4j.list;

import java.util.*;
import java.util.stream.Collectors;

public class ConvertList2Array {
    public Integer[][] toArray(List<Integer> list, int rows) {
        Integer[][] array = list.stream().toArray(size -> new Integer[rows][rows]); // Не совсем понял логику...
        return array;
    }
    public List<Integer> convert(List<int[]> list) {
        return list.stream()
                .map(x -> Arrays.stream(x)
                        .boxed().collect(Collectors.toCollection(ArrayList<Integer>::new))
                ).collect(ArrayList<Integer>::new,
                        ArrayList<Integer>::addAll, ArrayList<Integer>::addAll);
    }
}