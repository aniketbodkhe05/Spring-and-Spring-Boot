package in.aniket.crudSpringbootDemo.service;

import in.aniket.crudSpringbootDemo.dto.StudentResponseDto;
import in.aniket.crudSpringbootDemo.dto.StudentrequestDto;
import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private static StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentResponseDto createStudent(StudentrequestDto studentrequestDto){


       Student student= mapToEntity(studentrequestDto);
       student.setCreatedAt(LocalDateTime.now());
       student.setUpdateddAt(LocalDateTime.now());

       Student studentresponse= studentRepository.save(student);

       return mapToDto(studentresponse);

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

    private Student mapToEntity(StudentrequestDto studentrequestDto){
        Student student= new Student();
        student.setName(studentrequestDto.getName());
        student.setAge(studentrequestDto.getAge());
        student.setEmail(studentrequestDto.getEmail());
        student.setRollNo(studentrequestDto.getRollNo());
        student.setSubject(studentrequestDto.getSubject());

        return student;
    }
    private StudentResponseDto mapToDto(Student  student){
        StudentResponseDto responseDto=new StudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student Saved Successfully !");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdateddAt(student.getUpdateddAt());

        return responseDto;

    }
}
