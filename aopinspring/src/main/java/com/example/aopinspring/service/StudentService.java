package com.example.aopinspring.service;

import com.example.aopinspring.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(Student student){
        System.out.println("Student is saved Successfully ");
    }
}
