package ru.job4j.carstrorage.logic.items;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adstorage")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private User users;
    private String description;
    private Integer sale;
    private boolean status;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    private Car car;

    public Ad() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ad ad = (Ad) o;
        return status == ad.status && Objects.equals(id, ad.id) && Objects.equals(name, ad.name) && Objects.equals(users, ad.users) && Objects.equals(description, ad.description) && Objects.equals(sale, ad.sale)  && Objects.equals(car, ad.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, users, description, sale, status, car);
    }

    @Override
    public String toString() {
        return "Ad{" + "id=" + id + ", name='" + name + '\'' + ", user=" + users + ", description='" + description + '\'' + ", sale=" + sale + ", status=" + status + ", car=" + car + '}';
    }
}
