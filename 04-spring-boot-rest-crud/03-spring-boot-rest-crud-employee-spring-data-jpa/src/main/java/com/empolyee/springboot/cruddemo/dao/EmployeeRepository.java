package com.empolyee.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empolyee.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
