package com.example.course_management.Controller;


import com.example.course_management.Models.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Student")
@RestController
public class StudentController {

    @PostMapping("/register")
    public Student studentRegistration(@RequestBody )

}
