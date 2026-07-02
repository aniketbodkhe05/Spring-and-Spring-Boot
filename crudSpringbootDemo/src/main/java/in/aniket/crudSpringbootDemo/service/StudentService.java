package in.aniket.crudSpringbootDemo.service;

import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private static StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public Student createStudent(Student studentreq){


        Student studentresp=studentRepository.save(studentreq);
        return studentresp;

    }
    public static Student getStudent(Long id){
        Optional<Student> studentres=studentRepository.findById(id);
        if(studentres.isPresent()){
            return studentres.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        return studentList;
    }

    public Student updateStudent(Long id,Student studentreq){
        Optional<Student> existingStudent=studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentreq.getName());
        studentToSave.setAge(studentreq.getAge());
        studentToSave.setEmail(studentreq.getEmail());
        studentToSave.setRollNo(studentreq.getRollNo());
        studentToSave.setSubject(studentreq.getSubject());

        return studentRepository.save(studentToSave);

    }
    public Boolean deleteStudent(Long id){
       Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;
         studentRepository.deleteById(id);

         return true;
    }
}
