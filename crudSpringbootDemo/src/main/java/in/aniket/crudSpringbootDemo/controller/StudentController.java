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

    @PostMapping("/create")
    public ResponseEntity<StudentResponseDto> createStudent(@Valid @RequestBody StudentrequestDto studentrequestDto){


      StudentResponseDto createdstudent= studentService.createStudent(studentrequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }
    //read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(@PathVariable Long id){
        StudentResponseDto studentresponse= studentService.getStudent(id);


        if(studentresponse==null){
          return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentresponse);
    }

    //read all students
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        List<StudentResponseDto> studentList= studentService.getAllStudent();


        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateResponseDto> updateStudent(@PathVariable Long id,@RequestBody UpdateRequestDTO updateRequestDTO){
        UpdateResponseDto studentresponse= studentService.updateStudent(id,updateRequestDTO);


        if(studentresponse==null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentresponse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }

}

