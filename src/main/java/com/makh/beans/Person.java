package com.makh.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Person extends User {
    private String name;
    private String surname;
    private LocalDate birthday;

    public Person() {
        super();
        this.name = "no-name";
        this.surname = "no-surname";
        this.birthday = LocalDate.now();
    }

    public Person(String name, String surname, String login, String password ) {
        super(login, password);
        this.name = name;
        this.surname = surname;
        this.birthday = LocalDate.now();
    }

    public Person(String name, String surname, LocalDate birthday,
                  String login, String password, UserState state, UserGroup group) {
        super(login, password, state, group);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Person(String name, String surname, LocalDate birthday,
                  String login, String password, UserState state, UserGroup group,
                  LocalDateTime created, LocalDateTime lastAccess) {
        super(login, password, state, group, created, lastAccess);
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
