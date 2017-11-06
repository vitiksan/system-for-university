package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teacher extends Person implements Identificator<Integer> {
    private int id;
    private String academicStatus;
    private ArrayList<Class> classes;

    public Teacher() {
        super();
        this.id = 0;
        this.academicStatus = "аспірант";
        this.classes = new ArrayList<>();
    }

    public Teacher(String name, String surname, String login, String password,
                   int id, String academicStatus, ArrayList<Class> classes) {
        super(name, surname, login, password);
        this.id = id;
        this.academicStatus = academicStatus;
        this.classes = classes;
    }

    public Teacher(String name, String surname, LocalDate birthday, String login, String password,
                   UserState state, UserGroup group,
                   int id, String academicStatus, ArrayList<Class> classes) {
        super(name, surname, birthday, login, password, state, group);
        this.id = id;
        this.academicStatus = academicStatus;
        this.classes = classes;
    }

    public Teacher(String name, String surname, LocalDate birthday, String login, String password,
                   UserState state, UserGroup group, LocalDateTime created, LocalDateTime lastAccess,
                   int id, String academicStatus, ArrayList<Class> classes) {
        super(name, surname, birthday, login, password, state, group, created, lastAccess);
        this.id = id;
        this.academicStatus = academicStatus;
        this.classes = classes;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
    }

    public ArrayList<Class> getclasses() {
        return classes;
    }

    public void setclasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", academicStatus='" + academicStatus + '\'' +
                ", classes=" + classes +
                '}';
    }
}
