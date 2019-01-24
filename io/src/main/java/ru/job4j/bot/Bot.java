package ru.job4j.bot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot implements BotAction {
    private BufferedReader reader;
    private List<String> list = new ArrayList<>();
    private Random random = new Random();
    private boolean flag = true;
    @Override
    public String say() {
        try (
                FileInputStream fs = new FileInputStream("C:\\Projects\\file.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fs));
        ) {
           String read;
           while ((read = reader.readLine() ) != null) {
               list.add(read);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag ? list.get(random.nextInt(list.size())) : ("I'm waiting while flag will true");
    }

    public List<String> getList() {
        return list;
    }

    public boolean isFlag() {
        return flag;
    }

    public boolean stop() {
        return flag = false;
    }

    public boolean start() {
        return flag = true;
    }

}
