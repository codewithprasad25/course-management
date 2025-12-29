package com.example.course_management.service;

import com.example.course_management.models.Student;
import com.example.course_management.repository.StudentRepo;
import com.example.course_management.requestDto.StudentRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student register(StudentRegistrationDto registrationDto){//return student object
        Student student = new Student();
        student.setName(registrationDto.getName());
        student.setEmail(registrationDto.getEmail());
        student.setPassword(registrationDto.getPassword());

        return studentRepo.save(student);
    }

}
