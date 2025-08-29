package com.kvh.cruddemo.dao;

import com.kvh.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
    //C
        // Save the student
    void save(Student theStudent);
    //R
        // Find Student by id;
    Student findById(Integer id);
        // JPQL Read all the students
    List<Student> findAll();
        // JPQL read by student last name
    List<Student> findByLastName(String lastName);
    //U
       // Find Student by id;
    void update(Student theStudent);
    //D
        //delete the student.
    void delete(Integer id);

    int deleteAll();


}
