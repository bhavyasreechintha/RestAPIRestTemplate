package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Student;
import com.spring.service.StudentService;

@RestController

public class StudentController {

	@Autowired

	StudentService service;

	@GetMapping("/all")

	public ResponseEntity<String> getAllStudents() {

		return service.getAll();

	}

	@GetMapping("/all/{id}")

	public Student getEmployeeById(@PathVariable("id") int id) {

		return service.getStudentById(id);

	}

	@PostMapping("/post")
	
	public String createStudent(@RequestBody Student student)

	{
System.out.println("helllo");
		service.createStudent(student);

		return "student added successfully";

	}

	@PutMapping("/put/{id}")

	public String updateStudent(@PathVariable("id") int id, @RequestBody Student student) {

		service.updateStudent(id, student);

		return "student updated successfully";

	}

	@DeleteMapping("/delete/{id}")

	public String deleteStudent(@PathVariable("id") int id) {

		service.deleteStudent(id);

		return "student deleted successfully";

	}
}