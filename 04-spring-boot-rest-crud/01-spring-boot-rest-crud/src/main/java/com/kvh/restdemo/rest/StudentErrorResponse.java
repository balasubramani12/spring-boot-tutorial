package com.kvh.restdemo.rest;

public class StudentErrorResponse {

    private int status;
    private String message;
    private long timeStamp;

    public StudentErrorResponse(int status, String message, long timeStamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    // Getter Methods ...
    public int getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
    public long getTimeStamp(){
        return this.timeStamp;
    }

    // Setter Methods ...
    public void setStatus(int status){
        this.status = status;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setTimeStamp(long timeStamp){
        this.timeStamp = timeStamp;
    }

    
}
