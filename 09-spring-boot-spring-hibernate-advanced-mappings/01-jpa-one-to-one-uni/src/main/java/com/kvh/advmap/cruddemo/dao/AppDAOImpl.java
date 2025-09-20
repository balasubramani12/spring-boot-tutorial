package com.kvh.advmap.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kvh.advmap.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {

    //define field for entitymanager
    private EntityManager entityManager;
    //set up constructor injection
    @Autowired
    public AppDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    } 
    
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor=entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }


}
