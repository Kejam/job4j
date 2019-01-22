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
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return result;
    }

    public BufferedOutputStream dropAbuses(InputStream in, OutputStream out, String[] abuse) {
        BufferedOutputStream bo = new BufferedOutputStream(out);
        String value = "";
        char c;
        try (
                BufferedInputStream bf = new BufferedInputStream(in);
                ) {
            while (bf.available() != 0) {
                c = (char) bf.read();
                if (c == ' ' && containInArray(abuse, value)) {
                    bo.write(value.getBytes());
                }
                value += c;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return bo;
    }

    private boolean containInArray(String[] array, String checkValue) {
        boolean result = false;
        for (String s: array) {
            if (s.equals(checkValue)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void close() throws Exception {

    }
}
