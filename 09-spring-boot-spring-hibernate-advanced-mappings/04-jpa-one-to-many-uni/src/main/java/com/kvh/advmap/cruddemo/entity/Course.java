package com.kvh.advmap.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import jakarta.persistence.CascadeType;

@Entity
@Table(name="course")
public class Course {

    // define fields
    //define constructors
    //define getters/setters
    //define toString   
    //annotate fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Review> reviews;
    // Constructors
    public Course() {
    }
    public Course(String title) {
        this.title = title;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }   
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Instructor getInstructor() {
        return instructor;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public List<Review> getReviews() {
        return reviews;
    }   
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public void addReview(Review theReview) {
        if (reviews == null) {
            reviews = new java.util.ArrayList<>();
        }
        reviews.add(theReview);
    }
    

    // toString
    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }
    
    
}
