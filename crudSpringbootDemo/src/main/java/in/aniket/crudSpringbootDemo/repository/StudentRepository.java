package in.aniket.crudSpringbootDemo.repository;

import in.aniket.crudSpringbootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository   {

    public Student saveStudent(Student studentreq){

        System.out.println("Inside StudentRepository");
        return null;
    }
}
