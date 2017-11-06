package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teacher extends Person implements Identificator<Integer> {
    private int id;
    private String academicStatus;
    private LocalDate beganWork;
    private ArrayList<Class> classes;

    public Teacher() {
        super();
        this.id = 0;
        this.academicStatus = "aspirant";
        beganWork = LocalDate.now();
        this.classes = new ArrayList<>();
    }

    public Teacher(String name, String surname, String login, String password,
                   int id, String academicStatus) {
        super(name, surname, login, password);
        this.id = id;
        this.academicStatus = academicStatus;
        beganWork = LocalDate.now();
        this.classes = new ArrayList<>();
    }

    public Teacher(String name, String surname, LocalDate birthday, String login, String password,
                   UserState state, UserGroup group,
                   int id, String academicStatus, LocalDate beganWork, ArrayList<Class> classes) {
        super(name, surname, birthday, login, password, state, group);
        this.id = id;
        this.academicStatus = academicStatus;
        this.beganWork = beganWork;
        this.classes = classes;
    }

    public Teacher(String name, String surname, LocalDate birthday, String login, String password,
                   UserState state, UserGroup group, LocalDateTime created, LocalDateTime lastAccess,
                   int id, String academicStatus, LocalDate beganWork, ArrayList<Class> classes) {
        super(name, surname, birthday, login, password, state, group, created, lastAccess);
        this.id = id;
        this.academicStatus = academicStatus;
        this.beganWork = beganWork;
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

    public LocalDate getBeganWork() {
        return beganWork;
    }

    public void setBeganWork(LocalDate beganWork) {
        this.beganWork = beganWork;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
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
