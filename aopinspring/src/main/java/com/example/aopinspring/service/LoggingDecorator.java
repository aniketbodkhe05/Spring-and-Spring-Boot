package com.example.aopinspring.service;

import com.example.aopinspring.dto.Student;
import org.springframework.stereotype.Component;

@Component
public class LoggingDecorator implements StudentService{

    private StudentServiceImpl studentServiceimpl;
    @Override
    public void createStudent(Student student) {
        //Logging Related Logic
        LoggingServiceUtil.logStart("StudentServiceImpl","createStudent");

        studentServiceimpl.createStudent(student);
    }
}
