package com.jpaopgave.peter.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "students")
    private Set<Course> Courses;

    @ManyToOne
    private StudentPsychologist psychologist;

    public Student(String firstName, String lastName, Set<Course> courses, StudentPsychologist psychologist) {
        this.firstName = firstName;
        this.lastName = lastName;
        Courses = courses;
        this.psychologist = psychologist;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<Course> getCourses() {
        return Courses;
    }

    public void setCourses(Set<Course> courses) {
        Courses = courses;
    }

    public StudentPsychologist getPsychologist() {
        return psychologist;
    }

    public void setPsychologist(StudentPsychologist psychologist) {
        this.psychologist = psychologist;
    }
}
