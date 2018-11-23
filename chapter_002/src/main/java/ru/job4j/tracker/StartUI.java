package ru.job4j.tracker;
/** @author Aleksey Prozorov (kejamwork@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDBYID = "4";
    private static final String FINDBYNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;
    /**
     * Default constructor.
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     *  Init in app.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.answer("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDBYID.equals(answer)) {
                this.findById();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    /**
     *  Create item.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.answer("Введите имя заявки :");
        String desc = this.input.answer("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }
    /**
     * Show menu.
     */
    private void showMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu\n");
        sb.append("0. Add new Item\n");
        sb.append("1. Show all items\n");
        sb.append("2. Edit item\n");
        sb.append("3. Delete item\n");
        sb.append("4. Find item by Id\n");
        sb.append("5. Find items by name\n");
        sb.append("6. Exit Program\n");
        System.out.print(sb);
    }
    /**
     *  Edit task.
     */
    public void edit() {
        System.out.println("------------ Изменение заявки --------------");
        String name = this.input.answer("Введите имя заявки :");
        String desc = this.input.answer("Введите описание заявки :");
        String id = this.input.answer("Введите id заявки :");
        Item item = new Item(name, desc);
        boolean result = this.tracker.replace(id, item);
        if (result == true) {
            System.out.println("Изменена зявка с id " + item.getId());
        }
        else {
            System.out.println("Заявка не найдена");
        }
    }
    /**
     * Show all tasks.
     */
    private void showAll() {
        System.out.println("Все заявки: ");
        Item[] item = this.tracker.findAll();
        for (Item item1: item) {
            System.out.print(item1);
        }
    }
    /**
     * Delete task.
     */
    private void delete() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.answer("Введите id заявки :");
        boolean result = this.tracker.delete(id);
        if (result == true) {
            System.out.println("Заявка удалена");
        }
        else {
            System.out.println("Заявка не найдена");
        }
    }
    /**
     * Find by id.
     */
    private void findById() {
        System.out.println("------------ Поиск заявки по id --------------");
        String id = this.input.answer("Введите id заявки :");
        Item item = this.tracker.findById(id);
        if (item.equals(null)) {
            System.out.println("Not found");
        } else {
            System.out.println(item);
        }
    }
    /**
     * Find by name.
     */
    private  void  findByName() {
        System.out.println("------------ Поиск заявки по id --------------");
        String name = this.input.answer("Введите name заявки :");
        Item[] item = this.tracker.findByName(name);
        if (item.equals(item.length)) {
            System.out.println("Not found");
        } else {
            for (Item item1: item) {
                System.out.println(item1);
            }
        }
    }
    /**
     * Start app.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}