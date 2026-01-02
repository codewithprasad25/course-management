package com.example.course_management.service;


import com.example.course_management.models.Enrollment;
import com.example.course_management.models.Student;
import com.example.course_management.repository.EnrollmentRepo;
import com.example.course_management.repository.StudentRepo;
import com.example.course_management.requestDto.EnrollmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EnrollmentService {

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    EnrollmentRepo enrollmentRepo;

            public Enrollment enroll(EnrollmentDto dto) {
                Student student = studentRepo.findByEmail(dto.getStudentEmail());
                Enrollment enrollment = new Enrollment();
                enrollment.setStudentId(student.getId());
                enrollment.setCourseId(dto.getCourseId());
                enrollment.setEnrolledDate(LocalDate.now());

                return enrollmentRepo.save(enrollment);

            }
}
