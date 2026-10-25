
package com.example.aopadvance.servicd;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public String createStudent() {
        return "Student Saved";
    }
}
