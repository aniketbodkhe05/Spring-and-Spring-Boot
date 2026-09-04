package in.aniket.crudSpringbootDemo.service;

import in.aniket.crudSpringbootDemo.dto.StudentResponseDto;
import in.aniket.crudSpringbootDemo.dto.StudentrequestDto;
import in.aniket.crudSpringbootDemo.dto.UpdateRequestDTO;
import in.aniket.crudSpringbootDemo.dto.UpdateResponseDto;
import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.exception.ResourceNotFoundException;
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
    public StudentResponseDto getStudent(Long id) {
       Student studentres = studentRepository
               .findById(id)
               .orElseThrow(() ->
                       new ResourceNotFoundException("Student with id "+id+"Not found"));

//        if (studentres.isPresent()) {
//            return mapToDto(studentres.get());
//        }
//
//        return null;

        return mapToDto(studentres);
    }

    public List<StudentResponseDto> getAllStudent() {

        List<Student> studentList = studentRepository.findAll();

        return studentList.stream()
                .map(this::mapToDto)
                .toList();
    }
    public UpdateResponseDto updateStudent(Long id, UpdateRequestDTO updateRequestDTO){
        Optional<Student> existingStudent=studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(updateRequestDTO.getName());
        studentToSave.setAge(updateRequestDTO.getAge());

        studentToSave.setRollNo(updateRequestDTO.getRollNo());
        studentToSave.setSubject(updateRequestDTO.getSubject());
        studentToSave.setUpdateddAt(LocalDateTime.now());


Student savedstudent=  studentRepository.save(studentToSave);

return  mapToUpdateDto(savedstudent);

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

    private UpdateResponseDto mapToUpdateDto(Student student){
        UpdateResponseDto responseDto= new UpdateResponseDto();
        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student Updated Successfully !");
        responseDto.setUpdateddAt(student.getUpdateddAt());

        return responseDto;

    }
}
