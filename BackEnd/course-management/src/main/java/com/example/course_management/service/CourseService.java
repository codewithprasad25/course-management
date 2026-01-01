package com.example.course_management.service;

import com.example.course_management.models.Course;
import com.example.course_management.repository.CourseRepo;
import com.example.course_management.requestDto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public Course createCourse(CourseDto courseDto){
        Course course = new Course();
        course.setName(courseDto.getName());
        course.setInstructor(courseDto.getInstructor());
        course.setDuration(courseDto.getDuration());
        course.setStatus(courseDto.getStatus());

        return courseRepo.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepo.getAllCourses();
    }
}
