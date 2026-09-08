package com.filtersdemo.filtersDemo.controller;


import com.filtersdemo.filtersDemo.dto.Student;
import com.filtersdemo.filtersDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student){
        studentService.createStudent(student);

        return ResponseEntity.ok("Done");

    }
}
