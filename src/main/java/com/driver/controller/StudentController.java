package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody()Student student){
        studentService.createStudent(student);;
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    //Add required annotations
    @GetMapping("/ByEmail")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam("email") String email){
        return new ResponseEntity<>(studentService.getDetailsByEmail(email), HttpStatus.OK);
    }

    //Add required annotations
    @GetMapping("/ById")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") int id){

        return new ResponseEntity<>(studentService.getDetailsById(id), HttpStatus.OK);
    }



    //Add required annotations
    @PutMapping("/update")
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @DeleteMapping("/DeleteById")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") int id){

        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
