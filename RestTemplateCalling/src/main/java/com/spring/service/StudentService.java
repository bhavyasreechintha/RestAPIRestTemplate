package com.spring.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.Student;

@Service
public class StudentService {

	@Autowired

	RestTemplate restTemplate;

	public ResponseEntity<String> getAll() {

		String url = "http://localhost:9090/get";
	
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		String stu = response.getBody();

		System.out.println(stu);

		return response;

	}

	public Student getStudentById(int id) {

		String url = "http://localhost:9090/get/{id}";

		Student stu = restTemplate.getForObject(url, Student.class, id);

		return stu;

	}

	public String createStudent(Student student) {

		String url = "http://localhost:9090/save";

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);

		return restTemplate.exchange(

				url, HttpMethod.POST, entity, String.class).getBody();

	}

	public String updateStudent(int id, Student student) {

		String url = "http://localhost:9090/" + id;

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);

		return restTemplate.exchange(

				url, HttpMethod.PUT, entity, String.class).getBody();

	}

	public String deleteStudent(int id) {

		String url = "http://localhost:9090/" + id;

		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Student> entity = new HttpEntity<Student>(headers);

		return restTemplate.exchange(

				url, HttpMethod.DELETE, entity, String.class).getBody();

	}

}