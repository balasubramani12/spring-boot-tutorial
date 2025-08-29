package com.empolyee.springboot.cruddemo.dao;

import java.util.List;

import com.empolyee.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {
    // get all employees
    List<Employee> findAll();

    // get an employee by Id
    Employee findById(int id);

    // update a new employee
    Employee save(Employee theEmployee);

    // delete existing employee
    void deleteById(int id);

}
