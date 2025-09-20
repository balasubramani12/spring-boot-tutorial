package com.kvh.advmap.cruddemo.dao;

import java.util.List;

import com.kvh.advmap.cruddemo.entity.Course;
import com.kvh.advmap.cruddemo.entity.Instructor;
import com.kvh.advmap.cruddemo.entity.InstructorDetail;
import com.kvh.advmap.cruddemo.entity.Student;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);
    void updateCourse(Course tempCourse);
    Course findCourseById(int theId);

    void deleteCourseById(int theId);
    void save(Course theCourse);
    Course findCourseAndReviewsById(int theId); 
    //void deleteCourseAndReviewsById(int theId);

    Course findCourseAndStudentsById(int theId);
    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student theStudent);
    void deleteStudentById(int theId);
}
