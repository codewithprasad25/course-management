package com.example.course_management.repository;


import com.example.course_management.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EnrollmentRepo {
    Map<Integer, Enrollment> enrollmentDB = new HashMap<>();
    int id = 1;

    public Enrollment save(Enrollment enrollment){
        if(enrollmentDB.containsKey(enrollment.getId())){
            enrollment.setId(id);
            id++;
            enrollmentDB.put(enrollment.getId(), enrollment);

            return enrollment;
        }
        return null;
    }
}
