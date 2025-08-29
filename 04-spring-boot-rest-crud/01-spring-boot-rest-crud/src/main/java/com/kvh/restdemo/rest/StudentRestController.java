package com.kvh.restdemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kvh.restdemo.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define a list student data ...
    private List<Student> theStudents;
    @PostConstruct
    public void postData(){
        theStudents = new ArrayList<>();
        Student s1 = new Student("Mary","John");
        Student s2 = new Student("Abhishek","Sharma");
        Student s3 = new Student("Planty","Heado");
        Student s4 = new Student("Mario","Sandy");
        theStudents.addAll(Arrays.asList(s1, s2, s3, s4));
    }

    // define endpoint for "/students" - returns a list of all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
    // Only Throwing
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {

        // check the student again
        if(studentId < 0 || studentId >= theStudents.size()){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }


}
