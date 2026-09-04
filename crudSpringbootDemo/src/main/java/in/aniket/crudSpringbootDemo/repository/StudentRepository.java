package in.aniket.crudSpringbootDemo.repository;

import in.aniket.crudSpringbootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Struct;


public interface StudentRepository extends JpaRepository<Student,Long> {


static Boolean existsByEmail(String emailId);

}
