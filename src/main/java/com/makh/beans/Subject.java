package com.makh.beans;

import com.makh.dao.Identificator;

public class Subject implements Identificator<Integer> {
    private int id;
    private String name;
    private String academicDepartment;
    private int countHours;
    private int countCredits;

    public Subject() {
        this.id = 0;
        this.name = "name";
        this.academicDepartment = "academicDepartment";
        this.countHours = 0;
        this.countCredits = 0;
    }

    public Subject(String name, String academicDepartment, int countHours, int countCredits) {
        this.id = 0;
        this.name = name;
        this.academicDepartment = academicDepartment;
        this.countHours = countHours;
        this.countCredits = countCredits;
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

    public String getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(String academicDepartment) {
        this.academicDepartment = academicDepartment;
    }

    public int getCountHours() {
        return countHours;
    }

    public void setCountHours(int countHours) {
        this.countHours = countHours;
    }

    public int getCountCredits() {
        return countCredits;
    }

    public void setCountCredits(int countCredits) {
        this.countCredits = countCredits;
    }
}
