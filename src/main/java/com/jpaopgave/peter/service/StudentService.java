package com.jpaopgave.peter.service;

import com.jpaopgave.peter.model.Course;
import com.jpaopgave.peter.model.Student;
import com.jpaopgave.peter.repository.CourseRepo;
import com.jpaopgave.peter.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public String create(Student student) {
        studentRepo.create(student);
        return null;
    }

    public List<Student> fetchAll() {
        return studentRepo.fetchAll();
    }

    public Boolean deleteStudent(int id) {
        return studentRepo.deleteStudent(id);
    }

    public Student updateStudent(int id, Student student) {
        return studentRepo.updateStudent(id, student);

    }

    public Student fetchById(int id) {
        return studentRepo.fetchById(id);
    }
}
