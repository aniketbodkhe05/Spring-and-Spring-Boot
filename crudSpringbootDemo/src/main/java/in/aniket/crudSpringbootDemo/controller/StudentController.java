package in.aniket.crudSpringbootDemo.controller;

import in.aniket.crudSpringbootDemo.dto.StudentResponseDto;
import in.aniket.crudSpringbootDemo.dto.StudentrequestDto;
import in.aniket.crudSpringbootDemo.dto.UpdateRequestDTO;
import in.aniket.crudSpringbootDemo.dto.UpdateResponseDto;
import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentrequestDto studentrequestDto){


      StudentResponseDto createdstudent= studentService.createStudent(studentrequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }
    //read one student
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id){
        StudentResponseDto studentresponse= studentService.getStudent(id);


        if(studentresponse==null){
          return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentresponse);
    }

    //read all students
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> studentList= studentService.getAllStudent();



        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateResponseDto> updateStudent(@PathVariable Long id,@RequestBody UpdateRequestDTO updateRequestDTO){
        UpdateResponseDto studentresponse= studentService.updateStudent(id,updateRequestDTO);
        if(studentresponse==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentresponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
       studentService.deleteStudent(id);


        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

