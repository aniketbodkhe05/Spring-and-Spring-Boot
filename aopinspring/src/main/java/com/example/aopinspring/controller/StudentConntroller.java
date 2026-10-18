package com.example.aopinspring.controller;

import com.example.aopinspring.dto.Student;
import com.example.aopinspring.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentConntroller {

    private StudentServiceImpl studentServiceImpl;

    public StudentConntroller(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }
    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
    studentServiceImpl.createStudent(student);
    return ResponseEntity.ok("DOne");

    }
}
