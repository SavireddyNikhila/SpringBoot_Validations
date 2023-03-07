package com.springdemo.Service;

import java.util.List;

import com.springdemo.Entity.Department;
import com.springdemo.Exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchdepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

	public Department fetchdepartmentByName(String departmentName) throws DepartmentNotFoundException;

	public Department updateDepartmentByName(String departmentName, Department department) throws DepartmentNotFoundException;

	public void deleteDepartmentByName(String departmentName) throws DepartmentNotFoundException;

     
	
}
