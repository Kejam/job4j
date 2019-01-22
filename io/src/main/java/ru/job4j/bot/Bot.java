package ru.job4j.bot;

import java.io.*;
import java.util.List;
import java.util.Random;

public class Bot implements BotAction {
    private BufferedReader reader;
    private List<String> list;
    private Random random = new Random();
    @Override
    public String say() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Projects\\job4j\\io\\src\\main\\java\\ru\\job4j\\file.txt"));
        ) {
           String read = reader.readLine();
           while (read != null) {
               list.add(read);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.get(random.nextInt(list.size()));
    }

    public void stop() {

    }

    public void start() {

    }

}
