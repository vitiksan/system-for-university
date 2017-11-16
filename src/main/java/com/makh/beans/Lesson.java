package com.makh.beans;

import com.makh.dao.Identificator;

import java.time.LocalDateTime;

public class Lesson implements Identificator<Integer> {
    private int id;
    private Subject subject;
    private LessonType type;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int numberOfClass;
    private int teacherId;
    private int groupId;

    public Lesson() {
        this.id = 0;
        this.subject = new Subject();
        this.type = LessonType.LECTURE;
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.now();
        this.numberOfClass = 0;
        this.teacherId = 0;
        this.groupId = 0;
    }

    public Lesson(Subject subject, LessonType type, LocalDateTime startTime, LocalDateTime endTime, int numberOfClass, int teacherId, int groupId) {
        this.id = 0;
        this.subject = subject;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.numberOfClass = numberOfClass;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getNumberOfClass() {
        return numberOfClass;
    }

    public void setNumberOfClass(int numberOfClass) {
        this.numberOfClass = numberOfClass;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
