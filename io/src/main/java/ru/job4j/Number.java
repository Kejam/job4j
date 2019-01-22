package ru.job4j;

import java.io.*;
import java.util.stream.Collectors;

public class Number implements AutoCloseable {
    public boolean isNumber(InputStream in) {
        boolean result = false;
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
        ) {
            String value = br.lines().collect(Collectors.joining("\n"));
            if (Integer.valueOf(value) % 2 == 0) {
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
    }
}
