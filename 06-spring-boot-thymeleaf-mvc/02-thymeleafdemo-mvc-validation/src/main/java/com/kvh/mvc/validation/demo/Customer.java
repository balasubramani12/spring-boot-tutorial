package com.kvh.mvc.validation.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Customer {

    private String firstName;

    // Text
    @NotNull(message = "is Required")
    @Size(min = 1, message = "is Required")
    private String lastName;

    // Number range
    @NotNull(message = "is Required")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    @Max(value = 10, message = "Value must be lesser than or equal to 10")
    private Integer freePasses;

    // RegExp
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Must have 5 Characters")
    private String postalCode;

    // Empty constructor
    public Customer() {
    }

    // Non-empty constructor (firstName, lastName)
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Non-empty constructor (firstName, lastName, freePasses)
    public Customer(String firstName, String lastName, int freePasses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
    }

    // Non-empty constructor (firstName, lastName, freePasses, postalCode)
    public Customer(String firstName, String lastName, int freePasses, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.freePasses = freePasses;
        this.postalCode = postalCode;
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // toString method
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", freePasses=" + freePasses +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
