package ru.job4j;

import javafx.collections.transformation.FilteredList;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class Search {
    List<File> files(String parent, List<String> exts) {
        List<File> fileList = new ArrayList<>();
        File file = new File(parent);
        for (String s: exts) {
            FilenameFilter ff = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith("." + s);
                }
            };
            for (String y: file.list(ff)) {
                fileList.add(new File(y));
            }
        }
        return fileList;
    }
}
