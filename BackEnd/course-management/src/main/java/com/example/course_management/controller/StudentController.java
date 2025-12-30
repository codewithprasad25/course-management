package com.example.course_management.controller;


import com.example.course_management.models.Student;
import com.example.course_management.service.StudentService;
import com.example.course_management.requestDto.StudentRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/students")
@RestController
public class StudentController {


    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public Student studentRegistration(@RequestBody StudentRegistrationDto registrationDto){
        return studentService.register(registrationDto);
    }

}
