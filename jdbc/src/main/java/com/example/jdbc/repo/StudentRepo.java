package com.example.jdbc.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.jdbc.model.Student;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbcTemplate;

    public void save(Student s) {

        String sql = "INSERT INTO student (rollno, name, marks) VALUES (?,?,?)";
        int rows = jdbcTemplate.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println("student added to db " + rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "SELECT * FROM student";
        RowMapper<Student> rowMapper = (ResultSet rs, int rowNum) -> {
            Student student = new Student();
            student.setRollNo(rs.getInt("rollno"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getInt("marks"));
            return student;
        };
        return jdbcTemplate.query(sql, rowMapper);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
