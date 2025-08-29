package com.kvh.cruddemo.entity;

import jakarta.persistence.*;


//Step1: Map Class to Table
@Entity
@Table(name="student")
public class Student {

    //Step2: Define Fields
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

    //Step3: Define no-arg Constructors
    public Student(){

    }

    public Student(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    //Step4: Define Getters/Setters.
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    } 
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }  
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }      

    //Step5: Define toString() methods
    
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    
}
