package com.jpaopgave.peter.repository;

import com.jpaopgave.peter.model.Course;
import com.jpaopgave.peter.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    @Autowired
    JdbcTemplate template;


    public List<Student> fetchAll() {
        String sql = "SELECT * FROM STUDENT";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        return template.query(sql, rowMapper);
    }

    public void create(Student student) {
        String sql = "INSERT INTO STUDENT (FIRST_NAME, LAST_NAME, PSYCHOLOGIST_ID) VALUES(?, ?, ?)";
        template.update(sql, student.getFirstName(), student.getFirstName(), student.getPsychologist().getId());
    }

    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM STUDENT WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Student updateStudent(int id, Student student) {
        String sql = "UPDATE STUDENT SET FIRST_NAME=?, LAST_NAME=?, PSYCHOLOGIST_ID=? WHERE id=?";
        template.update(sql, student.getFirstName(), student.getLastName(), student.getPsychologist(), id);
        return null;
    }

    public Student fetchById(int id) {
        String sql = "SELECT * FROM STUDENT WHERE Id=?";
        RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = template.queryForObject(sql, rowMapper, id);
        return student;
    }
}
