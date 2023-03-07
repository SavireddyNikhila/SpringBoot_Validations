package com.springdemo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.Entity.Department;
import com.springdemo.Exception.DepartmentNotFoundException;
import com.springdemo.Service.DepartmentService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		logger.info("Inside fetchDepartmentList of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchdepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted Successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department) throws DepartmentNotFoundException {
		return departmentService.updateDepartmentById(departmentId,department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
		return departmentService.fetchdepartmentByName(departmentName);
	}
	
	@PutMapping("/departments/name/{name}")
	public Department updateDepartmentByName(@PathVariable("name") String departmentName,@RequestBody Department department) throws DepartmentNotFoundException {
		return departmentService.updateDepartmentByName(departmentName,department);
	}
	
	@Transactional
	@DeleteMapping("/departments/name/{name}")
	public String deleteDepartmentByName(@PathVariable("name") String departmentName) throws DepartmentNotFoundException {
		departmentService.deleteDepartmentByName(departmentName);
		return "Department deleted Successfully!!";
	}
}
