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
    private String fName;
    @Column(name="last_name")
    private String lName;
    @Column(name="email")
    private String email;

    //define constructors
    public Employee(){

    }
    public Employee(String fName, String lName, String email){
        this.fName=fName;
        this.lName=lName;
        this.email=email;
    }
    // define getter/setter
    public int getId(){
        return this.id;
    }
    public String getFirstName(){
        return this.fName;
    }
    public String getLastName(){
        return this.lName;
    }
    public String getEmail(){
        return this.email;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setFirstName(String fName){
        this.fName = fName;
    }
    public void setLastName(String lName){
        this.lName = lName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    //define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
