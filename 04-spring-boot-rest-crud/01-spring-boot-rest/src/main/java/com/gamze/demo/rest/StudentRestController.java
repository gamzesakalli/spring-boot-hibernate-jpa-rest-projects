package com.gamze.demo.rest;

import com.gamze.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void LoadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Gamze", "Sakallı"));
        theStudents.add(new Student("Mario", "Rossi"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
    return theStudents;
        }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check the studentaId again list size
        if(studentId>=theStudents.size()|| studentId<0){
            throw new StudentNotFoundException("Student id not found - "+studentId);

        }
        return theStudents.get(studentId);
    }


    //Add an exception handler using @ExceptionHandler
 @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        //create a StudentErrorResponse
     StudentErrorResponse error = new StudentErrorResponse();
     error.setStatus(HttpStatus.NOT_FOUND.value());
     error.setMessage(exc.getMessage());
     error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
 }


 //add another exception handler.. to catch any exception

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //return ResponseEntity

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);

    }




}
