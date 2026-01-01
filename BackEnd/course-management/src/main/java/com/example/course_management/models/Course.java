package com.example.course_management.models;

public class Course {
    int id;
    String name;
    String instructor;
    int duration;
    String status;

    public Course(int id, String name, String instructor, int duration, String status) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
        this.status = status;
    }

    public Course() {
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
