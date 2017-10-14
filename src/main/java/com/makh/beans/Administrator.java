package com.makh.beans;// Created by on 08.10.2017.

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Administrator extends User {
    private int id;
    private String email;
    private String phoneNumber;

    public Administrator() {
        super();
        this.id = 0;
        this.email = "no-email";
        this.phoneNumber = "no-phone-number";
    }

    public Administrator(String name, String surname,
                         String login, String password,
                         int id, String email, String phoneNumber) {
        super(name, surname, login, password);
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Administrator(String name, String surname, LocalDate birthday,
                         String login, String password, UserState state, UserGroup group,
                         int id, String email, String phoneNumber) {
        super(name, surname, birthday, login, password, state, group);
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Administrator(String name, String surname, LocalDate birthday,
                         String login, String password, UserState state, UserGroup group,
                         LocalDateTime created, LocalDateTime lastAccess,
                         int id, String email, String phoneNumber) {
        super(name, surname, birthday, login, password, state, group, created, lastAccess);
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
