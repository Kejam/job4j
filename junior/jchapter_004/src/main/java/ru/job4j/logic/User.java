package ru.job4j.logic;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Timestamp createDat;
    private String date;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setCreateDat(Timestamp createDat) {
        this.createDat = createDat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String login, String email, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDat = new Timestamp(System.currentTimeMillis());
        this.password = password;
    }

    public User(String id, String name, String login, String email, String createDate, String password) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDat = Timestamp.valueOf(createDate.replace("T"," ").replace("Z",""));
        this.password = password;
    }

    public String getID() {
        return String.valueOf(this.id);
    }

    public String getDate() {
        return String.valueOf(this.createDat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateDat() {
        return createDat;
    }


    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", login='" + login + '\'' + ", email='" + email + '\'' + ", createDat=" + createDat + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(email, user.email) && Objects.equals(createDat, user.createDat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, email, createDat);
    }
}
