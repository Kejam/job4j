package ru.job4j.menu;

import java.util.HashMap;
import java.util.Map;

public class Tasks implements MainMenu {
    @Override
    public void show(String string) {
        System.out.println("-" + string);
    }

    @Override
    public void show(String menu, HashMap<Integer, String[]> sub) {
        System.out.println("-" + menu);
        for (Map.Entry<Integer, String[]> entry : sub.entrySet()) {
            String value = "--";
            int count = 1;
            for (String s: entry.getValue()) {
                System.out.println(String.format("%s %d.%d %s", value, entry.getKey(), count, s));
                value += "-";
                count++;
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String[]> sub = new HashMap<>();
        sub.put(1, new String[] {"sfd", "sdf"});
        sub.put(2, new String[] {"saadf", "saadf"});
        new Tasks().show("Task.2", sub);
        new Tasks().show("Task.1");
        new Tasks().show("Task.3");
    }

}
