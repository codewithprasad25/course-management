package com.example.course_management.responseDto;

public class StudentResponseDto {
    String name;
    String email;

    public StudentResponseDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public StudentResponseDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
