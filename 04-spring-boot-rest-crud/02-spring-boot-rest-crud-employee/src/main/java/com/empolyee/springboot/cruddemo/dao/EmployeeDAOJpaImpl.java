package com.empolyee.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empolyee.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager.
    private EntityManager entityManager;
    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee", Employee.class);
        // execute query and get results
        List<Employee> theEmployees = theQuery.getResultList();
        // return results
        return theEmployees;
    }
    @Override
    public Employee findById(int id) {
    TypedQuery<Employee> theQuery = entityManager.createQuery("From Employee WHERE id=:theData", Employee.class);
        theQuery.setParameter("theData", id);
        return theQuery.getSingleResult();
    }
    @Override
    public Employee save(Employee theEmployee) {
        // save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return the employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee dbEmployee = entityManager.find(Employee.class, id);

        entityManager.remove(dbEmployee);
    }

}
