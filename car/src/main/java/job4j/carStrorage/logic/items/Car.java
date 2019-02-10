package job4j.carStrorage.logic.items;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carstorage")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "engine")
    private String engine;
    @Column(name = "carBody")
    private String carBody;
    @Column(name = "transmission")
    private String transmission;
    @Column(name = "color")
    private String color;

    public Car() {
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
