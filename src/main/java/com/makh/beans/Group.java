package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Group implements Identificator<Integer>{
    private int id;
    private String groupCode;
    private String specialty;
    private double averageRating;
    private LocalDate beganStudyDate;
    private HashSet<Student> members;
    private TreeSet<Class> classes;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public LocalDate getBeganStudyDate() {
        return beganStudyDate;
    }

    public void setBeganStudyDate(LocalDate beganStudyDate) {
        this.beganStudyDate = beganStudyDate;
    }

    public HashSet<Student> getMembers() {
        return members;
    }

    public void setMembers(HashSet<Student> members) {
        this.members = members;
    }

    public TreeSet<Class> getClasses() {
        return classes;
    }

    public void setClasses(TreeSet<Class> classes) {
        this.classes = classes;
    }
}
