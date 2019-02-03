package ru.job4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

public class SoftCash extends AbstractCash<String, String>{

    private final Path path;

    public SoftCash(Path path) {
        this.path = path;
    }

    @Override
    String getData(String key) {
        final String ls = System.getProperty("line.separator");
        StringBuilder builder = new StringBuilder();
        File file = new File(String.valueOf(path.getFileName()), key);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine()).append(ls);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
}
