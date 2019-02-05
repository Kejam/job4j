package job4j.carStrorage.logic.interfaces;

import job4j.carStrorage.logic.items.Car;
import java.util.List;

public interface StorageCar {
    boolean add(Car car);
    List<Car> returnAll();
    Car returnById(int id);
}
