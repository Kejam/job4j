package ru.job4j.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        IntStream intStream = Arrays.stream(array).flatMapToInt(x -> Arrays.stream(x));
        intStream.forEach((i) -> list.add(i));
        return list;
    }
}
