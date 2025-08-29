package com.kvh.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.kvh.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id){
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //Create the Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        //Return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //Create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        //Set Parameter
        theQuery.setParameter("theData", lastName);
        //return result
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve the student.
        Student theStudent = entityManager.find(Student.class, id);
        // remove the student.
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int affectedRows = entityManager.createQuery("DELETE From Student").executeUpdate();
        return affectedRows;
    }
}
