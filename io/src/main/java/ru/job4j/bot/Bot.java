package ru.job4j.bot;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

public class Bot implements BotAction {
    private List<String> list = new ArrayList<>();
    private boolean flag = true;
    @Override
    public String say() {
        Random random = new Random();
        try (
                FileInputStream fs = new FileInputStream(new File("io/src/main/resources/file.txt"));
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
