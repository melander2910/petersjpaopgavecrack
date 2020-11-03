package com.jpaopgave.peter.repository;

import com.jpaopgave.peter.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepo {

    @Autowired
    JdbcTemplate template;


    public List<Course> fetchAll() {
        String sql = "SELECT * FROM COURSE";
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);
        return template.query(sql, rowMapper);
    }

    public void create(Course course) {
        String sql = "INSERT INTO Course (NAME) VALUES(?)";
        template.update(sql, course.getName());
    }

    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM COURSE WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    public Course updateCourse(int id, Course course) {
        String sql = "UPDATE COURSE SET NAME=? WHERE id=?";
        template.update(sql, course.getName(), id);
        return null;
    }

    public Course fetchById(int id) {
        String sql = "SELECT * FROM COURSE WHERE Id=?";
        RowMapper<Course> rowMapper = new BeanPropertyRowMapper<>(Course.class);
        Course course = template.queryForObject(sql, rowMapper, id);
        return course;
    }
}
