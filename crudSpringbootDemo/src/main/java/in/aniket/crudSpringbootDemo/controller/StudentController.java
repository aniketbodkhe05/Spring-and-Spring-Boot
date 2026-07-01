package in.aniket.crudSpringbootDemo.controller;

import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.service.StudentService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public String createStudent(@RequestBody Student student){
        System.out.println("Inside StudentController");

        Student createdstudent= studentService.createStudent(student);

        return "Student Created";


    }
}

