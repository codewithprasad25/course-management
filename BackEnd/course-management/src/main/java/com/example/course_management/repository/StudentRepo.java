package com.example.course_management.repository;

import com.example.course_management.models.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepo {
    Map<Integer, Student> studentDb = new HashMap<>();
    int id = 1;

    public Student save(Student student){
        if(!studentDb.containsKey(student.getId())){
            student.setId(id);
            studentDb.put(student.getId(), student);
            return student;
        }
        return null;
    }
}
