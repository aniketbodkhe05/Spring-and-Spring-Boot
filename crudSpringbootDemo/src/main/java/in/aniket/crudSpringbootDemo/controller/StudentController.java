package in.aniket.crudSpringbootDemo.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping("api/students")
    public void createStudent(){

    }
}

