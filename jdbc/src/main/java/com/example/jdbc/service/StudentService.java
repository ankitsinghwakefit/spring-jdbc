package com.example.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbc.model.Student;
import com.example.jdbc.repo.StudentRepo;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    public void addStudent(Student student) {
        System.out.println("forwardered student to repo from service");
        studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
}
