package in.aniket.crudSpringbootDemo.controller;

import in.aniket.crudSpringbootDemo.entity.Student;
import in.aniket.crudSpringbootDemo.service.StudentService;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){


        Student createdstudent= studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdstudent);
    }
    //read one student
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentresponse= studentService.getStudent(id);


        if(studentresponse==null){
          return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentresponse);
    }

    //read all students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList= studentService.getAllStudent();


        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentreq){
        Student studentresponse= studentService.updateStudent(id,studentreq);


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

