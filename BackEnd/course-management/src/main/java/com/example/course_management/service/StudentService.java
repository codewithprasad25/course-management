package com.example.course_management.service;

import com.example.course_management.models.Student;
import com.example.course_management.repository.StudentRepo;
import com.example.course_management.requestDto.LoginDto;
import com.example.course_management.requestDto.StudentRegistrationDto;
import com.example.course_management.responseDto.StudentResponseDto;
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

    public StudentResponseDto login(LoginDto loginDto){
        Student student = studentRepo.findByEmail(loginDto.getEmail());
        if(student == null){
           throw new RuntimeException("User is not in our DB");
        }
        if(student.getPassword().equals(loginDto.getPassword())){
            StudentResponseDto responseDto = new StudentResponseDto();
            responseDto.setName(student.getName());
            responseDto.setEmail(student.getEmail());

            return responseDto;
        }
        return null;
    }

}
