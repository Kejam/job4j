package ru.job4j.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortTest {
    @Test
    public void whenSortUp() {
        Sort sort = new Sort();
        sort.add("K1\\SK1");
        sort.add("K2\\SK1");
        sort.add("K1\\SK1\\SSK2");
        sort.add("K1\\SK1\\SSK1");
        sort.add("K2");
        sort.add("K1");
        sort.add("K2\\SK1\\SSK1");
        sort.add("K2\\SK1\\SSK2");
        sort.sorter(0);
        ArrayList<String> actual = sort.getSort();
        List<String> expect =  List.of(
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        );
        assertThat(actual, is(expect));
    }
    @Test
    public void whenSortDown() {
        Sort sort = new Sort();
        sort.add("K1\\SK1");
        sort.add("K2\\SK1");
        sort.add("K1\\SK1\\SSK2");
        sort.add("K1\\SK1\\SSK1");
        sort.add("K2");
        sort.add("K1");
        sort.add("K2\\SK1\\SSK1");
        sort.add("K2\\SK1\\SSK2");
        sort.sorter(1);
        ArrayList<String> actual = sort.getSort();
        List<String> expect =  List.of(
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        );
        assertThat(actual, is(expect));
    }
}
