package com.department.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.department.Entity.StudentDetails;
import com.department.Repository.DepartmentRepository;

@Service
public class DepartmentService {

	private static final String BASE_URL = "http://localhost:8080";
	private static final String FIND_STUDENT_BY_ROLLNO_ENDPOINT = "/student/findByRollNo/{rollNo}";
	private static final String getAll = "/student/getAll";
	private static final String saveStudent = "/student/save";
	private static final String deleteStudent ="/student/delete/";

	@Autowired
	DepartmentRepository departmentRepository;

	private final RestTemplate restTemplate;

	@Autowired
	public DepartmentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<StudentDetails> getAllStudents() {
		String urlGe = BASE_URL + getAll;
		ResponseEntity<StudentDetails[]> response = restTemplate.getForEntity(urlGe, StudentDetails[].class);
		if (response.getStatusCode().is2xxSuccessful()) {
			StudentDetails[] studentsArray = response.getBody();
			return Arrays.asList(studentsArray); // Convert the array to a List and return
		} else {
			// Handle error response here (e.g., return null or throw an exception)
			return null;
		}

	}

    public StudentDetails findStudentByRollNo(int rollNo) {
        String url = BASE_URL + FIND_STUDENT_BY_ROLLNO_ENDPOINT.replace("{rollNo}", String.valueOf(rollNo));
        ResponseEntity<StudentDetails> response = restTemplate.getForEntity(url, StudentDetails.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle error response here (e.g., throw custom exception)
            throw new RuntimeException("Failed to find student: " + response.getStatusCode());
        }
    }


	public StudentDetails registerStudent(StudentDetails studentDetails) {
		String url = BASE_URL + saveStudent;
		ResponseEntity<StudentDetails> response = restTemplate.postForEntity(url, studentDetails, StudentDetails.class);

		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else {
			// Handle error response here (e.g., return null or throw an exception)
			return null;
		}
	}

	public void deleteStudent (int rollNo) {
	StudentDetails findStu=	findStudentByRollNo(rollNo);
	String url=BASE_URL+deleteStudent+rollNo;
	if(findStu!=null) {
	    ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
	}else {
        throw new RuntimeException("Failed to delete student: " );

	}
		
	}
	
}
