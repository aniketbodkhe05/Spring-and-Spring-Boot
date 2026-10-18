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

       try{
           Thread.sleep(2000);
       }catch (Exception e){
           System.out.println("Dont Worry God is there! Mahdeva ");
       }

       studentRepository.save(student);
    }
}
