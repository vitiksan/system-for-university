package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;

public class Group implements Identificator<Integer>{
    private int id;
    private String groupCode;
    private String speciality;
    private double averageRating;
    private LocalDate beganStudyDate;
    private HashSet<Student> members;
    private TreeSet<Lesson> lessons;

    public Group() {
        this.id= 0;
        this.groupCode = "";
        this.speciality = "";
        this.averageRating = 0;
        this.beganStudyDate = LocalDate.now();
        this.members = new HashSet<>();
        this.lessons = new TreeSet<>();
    }

    public Group(int id, String groupCode, String speciality, double averageRating, LocalDate beganStudyDate) {
        this.id = id;
        this.groupCode = groupCode;
        this.speciality = speciality;
        this.averageRating = averageRating;
        this.beganStudyDate = beganStudyDate;
        this.members = new HashSet<>();
        this.lessons = new TreeSet<>();
    }

    public Group(int id, String groupCode, String speciality, double averageRating,
                 LocalDate beganStudyDate, HashSet<Student> members, TreeSet<Lesson> lessons) {
        this.id = id;
        this.groupCode = groupCode;
        this.speciality = speciality;
        this.averageRating = averageRating;
        this.beganStudyDate = beganStudyDate;
        this.members = members;
        this.lessons = lessons;
    }

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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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

    public TreeSet<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(TreeSet<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupCode='" + groupCode + '\'' +
                ", speciality='" + speciality + '\'' +
                ", averageRating=" + averageRating +
                ", beganStudyDate=" + beganStudyDate +
                ", members=" + members +
                ", lessons=" + lessons +
                '}';
    }
}
