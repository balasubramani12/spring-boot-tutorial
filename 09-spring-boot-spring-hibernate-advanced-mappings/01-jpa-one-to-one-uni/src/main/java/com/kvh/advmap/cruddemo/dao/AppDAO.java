package com.kvh.advmap.cruddemo.dao;

import com.kvh.advmap.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
