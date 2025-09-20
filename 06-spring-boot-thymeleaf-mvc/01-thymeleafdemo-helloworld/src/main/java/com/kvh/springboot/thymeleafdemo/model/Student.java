package com.kvh.springboot.thymeleafdemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage; // 👈 existing field
    private List<String> favoriteSystems; // 👈 new field

    // Empty constructor
    public Student() {
    }

    // Non-empty constructor
    public Student(String firstName, String lastName, String country, String favoriteLanguage, List<String> favoriteSystems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.favoriteLanguage = favoriteLanguage;
        this.favoriteSystems = favoriteSystems;
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Getter and Setter for favoriteLanguage
    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    // Getter and Setter for favoriteSystems
    public List<String> getFavoriteSystems() {
        return favoriteSystems;
    }

    public void setFavoriteSystems(List<String> favoriteSystems) {
        this.favoriteSystems = favoriteSystems;
    }

    // Optional: toString() for debugging/logging
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", favoriteLanguage='" + favoriteLanguage + '\'' +
                ", favoriteSystems=" + favoriteSystems +
                '}';
    }
}
