package com.kvh.advmap.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kvh.advmap.cruddemo.entity.Instructor;
import com.kvh.advmap.cruddemo.entity.InstructorDetail;

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

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }
    @Override
    @Transactional 
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class, theId);
        //remove the associated object reference
        //break bi-directional link
        //tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }


}
