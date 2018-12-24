package ru.job4j.logic;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Date createDat;
    public User(int id, String name, String login, String email, Date createDat) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDat = createDat;
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

    public Date getCreateDat() {
        return createDat;
    }

    public void setCreateDat(Date createDat) {
        this.createDat = createDat;
    }
}
