package com.filtersdemo.filtersDemo.service;

import com.filtersdemo.filtersDemo.dto.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {

    @PostMapping
    public void createStudent(Student student){
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
