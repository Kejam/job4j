package job4j;

public class ImportUser {
    private UserStorage userStorage;
    private Storage storage;

    private void init(final Storage storage) {
        this.storage = storage;
        userStorage = new UserStorage(storage);
    }




}
