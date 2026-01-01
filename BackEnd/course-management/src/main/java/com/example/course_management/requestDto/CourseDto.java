package com.example.course_management.requestDto;

public class CourseDto {
    String name;
    String instructor;
    int duration;
    String status;

    public CourseDto(String name, String instructor, int duration, String status) {
        this.name = name;
        this.instructor = instructor;
        this.duration = duration;
        this.status = status;
    }

    public CourseDto() {
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
