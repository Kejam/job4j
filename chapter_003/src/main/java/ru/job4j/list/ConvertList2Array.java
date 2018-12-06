package ru.job4j.list;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        return list.stream().toArray();
    }
    public List<Integer> convert(List<int[]> list) {
        return list.stream()
                .map(x -> Arrays.stream(x)
                        .boxed().collect(Collectors.toCollection(ArrayList<Integer>::new))
                ).collect(ArrayList<Integer>::new,
                        ArrayList<Integer>::addAll, ArrayList<Integer>::addAll);
    }
}