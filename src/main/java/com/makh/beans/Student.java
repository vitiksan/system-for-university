package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student extends Person implements Identificator<Integer> {
    private int id;
    private String email;
    private double averageRating;
    private int groupId;

    public Student() {
        super();
        this.id = 0;
        this.email = "no-email";
        this.averageRating = 0;
        this.groupId = 0;
    }

    public Student(String name, String surname,
                   String login, String password,
                   int id, String email, double averageRating, int groupId) {
        super(name, surname, login, password);
        this.id = id;
        this.email = email;
        this.averageRating = averageRating;
        this.groupId = groupId;
    }

    public Student(String name, String surname, LocalDate birthday,
                   String login, String password, UserState state, UserGroup group,
                   int id, String email, double averageRating, int groupId) {
        super(name, surname, birthday, login, password, state, group);
        this.id = id;
        this.email = email;
        this.averageRating = averageRating;
        this.groupId = groupId;
    }

    public Student(String name, String surname, LocalDate birthday,
                   String login, String password, UserState state, UserGroup group,
                   LocalDateTime created, LocalDateTime lastAccess,
                   int id, String email, double averageRating, int groupId) {
        super(name, surname, birthday, login, password, state, group, created, lastAccess);
        this.id = id;
        this.email = email;
        this.averageRating = averageRating;
        this.groupId = groupId;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", groupId=" + groupId +
                '}';
    }
}
