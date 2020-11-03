package com.jpaopgave.peter.repository;

import com.jpaopgave.peter.model.StudentPsychologist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentPsychologistRepo {

    @Autowired
    JdbcTemplate template;


    public List<StudentPsychologist> fetchAll() {
        String sql = "SELECT * FROM STUDENT_PSYCHOLOGIST";
        RowMapper<StudentPsychologist> rowMapper = new BeanPropertyRowMapper<>(StudentPsychologist.class);
        return template.query(sql, rowMapper);
    }

    public void create(StudentPsychologist studentPsychologist) {
        String sql = "INSERT INTO STUDENT_PSYCHOLOGIST (FIRST_NAME, LAST_NAME) VALUES(?, ?)";
        template.update(sql, studentPsychologist.getFirstName(), studentPsychologist.getLastName());
    }

    public boolean deleteStudentPsychologist(int id) {
        String sql = "DELETE FROM STUDENT_PSYCHOLOGIST WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public StudentPsychologist updateStudentPsychologist(int id, StudentPsychologist studentPsychologist) {
        String sql = "UPDATE STUDENT_PSYCHOLOGIST SET FIRST_NAME=?, LAST_NAME=? WHERE id=?";
        template.update(sql, studentPsychologist.getFirstName(), studentPsychologist.getLastName(), id);
        return null;
    }

    public StudentPsychologist fetchById(int id) {
        String sql = "SELECT * FROM STUDENT_PSYCHOLOGIST WHERE Id=?";
        RowMapper<StudentPsychologist> rowMapper = new BeanPropertyRowMapper<>(StudentPsychologist.class);
        StudentPsychologist studentPsychologist = template.queryForObject(sql, rowMapper, id);
        return studentPsychologist;
    }

}
