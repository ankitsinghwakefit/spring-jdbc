package com.example.jdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.jdbc.model.Student;
import com.example.jdbc.service.StudentService;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
		Student s1 = context.getBean(Student.class);
		s1.setMarks(22);
		s1.setName("ankita");
		s1.setRollNo(13);
		System.out.println(s1);

		StudentService studentService = context.getBean(StudentService.class);
		// studentService.addStudent(s1);

		List<Student> students = studentService.getStudents();
		System.out.println(students);
	}

}
