package com.jpaopgave.peter.service;

import com.jpaopgave.peter.model.Course;
import com.jpaopgave.peter.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;

    public String create(Course course) {
        courseRepo.create(course);
        return null;
    }

    public List<Course> fetchAll() {
        return courseRepo.fetchAll();
    }

    public Boolean deleteCourse(int id) {
        return courseRepo.deleteCourse(id);
    }

    public Course updateCourse(int id, Course course) {
        return courseRepo.updateCourse(id, course);

    }

    public Course fetchById(int id) {
        return courseRepo.fetchById(id);
    }
}
