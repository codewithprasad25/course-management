package com.example.course_management.repository;

import com.example.course_management.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRepo {
    Map<Integer, Course> courseDB = new HashMap<>();
    int id = 1;

    public Course save(Course course){
        if(!courseDB.containsKey(course.getId())){
            course.setId(id);
            id++;
            courseDB.put(course.getId(), course);

            return course;
        }

        return null;
    }

    public List<Course> getAllCourses(){
        return new ArrayList<>(courseDB.values());
    }
}
