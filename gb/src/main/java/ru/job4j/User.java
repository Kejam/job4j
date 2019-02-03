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
        User.test();
    }

    public void test1() {
        while (true) {
            User user = new User();
        }
    }

    public static void test() {
        new Thread(
                () -> User.test()
        ).start();
    }
}
