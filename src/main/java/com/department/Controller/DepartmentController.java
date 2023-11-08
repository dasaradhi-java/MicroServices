package com.department.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.department.Entity.StudentDetails;
import com.department.Service.DepartmentService;

@RestController

@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
   
    @GetMapping("/getAll")
    public List<StudentDetails> GetAllStudents(){
        try {
        	List<StudentDetails>  dd= departmentService.getAllStudents();
            return dd;
        }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
       
    }    
    
    @GetMapping("/findStudentByRollNo")    
    public StudentDetails findStuByrollNo(@RequestParam int rollNo) {
    	return departmentService.findStudentByRollNo(rollNo);
    	
    }
    
    @PostMapping("/save")
	public StudentDetails registerStudent(@RequestBody StudentDetails studentDetails) {
		return departmentService.registerStudent(studentDetails);
	}
    @DeleteMapping("/deleteByRollNo/rollNo")
    public String deleteStudent(@RequestParam int rollNo) {
        departmentService.deleteStudent(rollNo);
        return "Successfully deleted with the rollNo  "+rollNo;
    }
}
