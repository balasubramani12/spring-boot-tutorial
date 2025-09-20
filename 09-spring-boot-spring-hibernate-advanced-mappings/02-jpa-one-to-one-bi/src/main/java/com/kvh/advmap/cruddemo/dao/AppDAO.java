package com.kvh.advmap.cruddemo.dao;

import com.kvh.advmap.cruddemo.entity.Instructor;
import com.kvh.advmap.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
