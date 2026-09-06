package in.aniket.crudSpringbootDemo.repository;

import in.aniket.crudSpringbootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String emailId);

}