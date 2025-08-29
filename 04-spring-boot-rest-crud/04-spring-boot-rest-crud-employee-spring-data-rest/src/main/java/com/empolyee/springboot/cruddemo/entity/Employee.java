package com.empolyee.springboot.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;

    //define constructors
    public Employee(){

    }
    public Employee(String firstName, String lastName, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }
    // define getter/setter
    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFirstName(String fName){
        this.firstName = fName;
    }
    public void setLastName(String lName){
        this.lastName = lName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
