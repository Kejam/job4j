package ru.job4j;

public class User {
    private String name;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        int kb = 1024;
        System.out.println(Runtime.getRuntime().totalMemory() / kb);
        int before = Math.toIntExact(Runtime.getRuntime().freeMemory() / kb);
        User user = new User();
        System.out.println(user);
        int after = Math.toIntExact(Runtime.getRuntime().freeMemory() / kb);
        int object = before - after;
        System.out.println(String.format("Before: %d After: %d Object: %d",before, after, object ));


        new Thread(
                () -> test()
        ).start();
    }

    public static void test() {
        int count = 0;
        while (count < 1000000) {
            User user = new User();
            count++;
        }
    }
}
