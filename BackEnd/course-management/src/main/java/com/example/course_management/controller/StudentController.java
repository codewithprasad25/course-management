package com.example.course_management.controller;


import com.example.course_management.models.Student;
import com.example.course_management.requestDto.LoginDto;
import com.example.course_management.responseDto.StudentResponseDto;
import com.example.course_management.service.StudentService;
import com.example.course_management.requestDto.StudentRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/students")
@RestController
@CrossOrigin("*")
public class StudentController {


    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public Student studentRegistration(@RequestBody StudentRegistrationDto registrationDto){
        return studentService.register(registrationDto);
    }

    @PostMapping("/login")
    public StudentResponseDto StudentLogin(@RequestBody LoginDto loginDto) {
        return studentService.login(loginDto);
    }


}
