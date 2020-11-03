package com.jpaopgave.peter.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class StudentPsychologist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "psychologist")
    private Set<Student> studentList;

    public StudentPsychologist(String firstName, String lastName, Set<Student> studentList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentList = studentList;
    }

    public StudentPsychologist() {
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

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}
