package com.jpaopgave.peter.service;

import com.jpaopgave.peter.model.Course;
import com.jpaopgave.peter.model.StudentPsychologist;
import com.jpaopgave.peter.repository.CourseRepo;
import com.jpaopgave.peter.repository.StudentPsychologistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentPsychologistService {

    @Autowired
    StudentPsychologistRepo studentPsychologistRepo;

    public String create(StudentPsychologist studentPsychologist) {
        studentPsychologistRepo.create(studentPsychologist);
        return null;
    }

    public List<StudentPsychologist> fetchAll() {
        return studentPsychologistRepo.fetchAll();
    }

    public Boolean deleteStudentPsychologist(int id) {
        return studentPsychologistRepo.deleteStudentPsychologist(id);
    }

    public StudentPsychologist updateStudentPsychologist(int id, StudentPsychologist studentPsychologist) {
        return studentPsychologistRepo.updateStudentPsychologist(id, studentPsychologist);

    }

    public StudentPsychologist fetchById(int id) {
        return studentPsychologistRepo.fetchById(id);
    }
}
