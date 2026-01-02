package com.example.course_management.controller;

import com.example.course_management.models.Enrollment;
import com.example.course_management.requestDto.EnrollmentDto;
import com.example.course_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
@CrossOrigin("*")


public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;


    @PostMapping("/create")
    public Enrollment enrollStudent(@RequestBody EnrollmentDto enrollmentDto){
        return enrollmentService.enroll(enrollmentDto);
    }

}
