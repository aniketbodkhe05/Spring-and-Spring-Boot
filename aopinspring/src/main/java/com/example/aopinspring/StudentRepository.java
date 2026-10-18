package com.example.aopinspring;

import com.example.aopinspring.dto.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public void save(Student student){
        System.out.println("Student is saved");
    }
}
