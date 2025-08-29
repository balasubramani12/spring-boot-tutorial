package com.kvh.restdemo.entity;

public class Student {
    private String fName;
    private String lName;

    public Student(String fName,String lName){
        this.fName = fName;
        this.lName = lName;
    }

    // Getter Methods & Setter Methods
    public String getFirstName(){
        return fName;
    }
    public void setFirstName(String fName){
        this.fName = fName;
    }
    public String getLastName(){
        return lName;
    }
    public void setLastName(String lName){
        this.lName = lName;
    }
}
