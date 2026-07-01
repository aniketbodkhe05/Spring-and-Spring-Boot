package in.aniket.crudSpringbootDemo.service;

import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student studentreq){
        System.out.println("Inside StudentService");

        Student studentresp=studentRepository.saveStudent(studentreq);
        return studentresp;

    }
}
