package com.example.aopinspring.service;

import com.example.aopinspring.StudentRepository;
import com.example.aopinspring.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public void createStudent(Student student){
       studentRepository.save(student);
    }
}
