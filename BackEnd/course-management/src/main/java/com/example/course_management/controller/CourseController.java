package com.example.course_management.controller;

import com.example.course_management.models.Course;
import com.example.course_management.requestDto.CourseDto;
import com.example.course_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin("*")
public class CourseController {

@Autowired
    CourseService courseService;

    @PostMapping("/create")
    public Course createCourse(@RequestBody CourseDto courseDto){
        return courseService.createCourse(courseDto);
    }

    @GetMapping("all")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
}
