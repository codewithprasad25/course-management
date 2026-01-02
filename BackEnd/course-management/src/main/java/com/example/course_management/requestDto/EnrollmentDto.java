package com.example.course_management.requestDto;

public class EnrollmentDto {
    String studentEmail;
    int courseId;

    public EnrollmentDto(String studentEmail, int courseId) {
        this.studentEmail = studentEmail;
        this.courseId = courseId;
    }

    public EnrollmentDto() {
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
