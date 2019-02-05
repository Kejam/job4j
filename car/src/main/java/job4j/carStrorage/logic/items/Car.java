package job4j.carStrorage.logic.items;

import java.util.Objects;

public class Car {
    private Integer id;
    private String name;
    private String engine;
    private String carBody;
    private String transmission;
    private String color;

    public Car() {
    }

    public Car(Integer id, String name, String engine, String carBody, String transmission, String color) {
        this.id = id;
        this.name = name;
        this.engine = engine;
        this.carBody = carBody;
        this.transmission = transmission;
        this.color = color;
    }

    public Car(String name, String engine, String carBody, String transmission, String color) {
        this.name = name;
        this.engine = engine;
        this.carBody = carBody;
        this.transmission = transmission;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(name, car.name) && Objects.equals(engine, car.engine) && Objects.equals(carBody, car.carBody) && Objects.equals(transmission, car.transmission) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, engine, carBody, transmission, color);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name='" + name + '\'' + ", engine='" + engine + '\'' + ", carBody='" + carBody + '\'' + ", transmission='" + transmission + '\'' + ", color='" + color + '\'' + '}';
    }
}
