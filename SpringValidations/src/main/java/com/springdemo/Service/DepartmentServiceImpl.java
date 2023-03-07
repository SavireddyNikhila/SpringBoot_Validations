package com.springdemo.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.Entity.Department;
import com.springdemo.Exception.DepartmentNotFoundException;
import com.springdemo.Repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchdepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department= departmentRepository.findById(departmentId);
		
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department Not Found with the given Id:"+departmentId);
	    return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		
		Optional<Department> department=departmentRepository.findById(departmentId);
		if(!department.isPresent())
			throw new DepartmentNotFoundException("Department Not Found with the given Id:"+departmentId);
		else
			departmentRepository.deleteById(departmentId);
			
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException {
		Optional<Department> dept=departmentRepository.findById(departmentId);
		if(!dept.isPresent())
			throw new DepartmentNotFoundException("Department Not Found with the given Id:"+departmentId);
		else
		{		
		Department depDB=departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) && 
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}

		return departmentRepository.save(depDB);
		}
	}

	@Override
	public Department fetchdepartmentByName(String departmentName) throws DepartmentNotFoundException {
		
		
		Department dep = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		if(dep==null) {
			throw new DepartmentNotFoundException("Department Not Found with department name : "+departmentName);
		}else {
			return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		}
	}

	@Override
	public Department updateDepartmentByName(String departmentName, Department department) throws DepartmentNotFoundException {
		
		Department dept = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		if(dept==null) {
			throw new DepartmentNotFoundException("Department Not Found with department name : "+departmentName);
		}else {

		//Department dept=departmentRepository.findByDepartmentName(departmentName);
		if(Objects.nonNull(department.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			dept.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode()) && 
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			dept.setDepartmentCode(department.getDepartmentCode());
		}
		
		
		return departmentRepository.save(dept);
		}
	}

	@Override
	public void deleteDepartmentByName(String departmentName) throws DepartmentNotFoundException {
		Department dep = departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
		if(dep==null) {
			throw new DepartmentNotFoundException("Department Not Found with department name : "+departmentName);
		}else {
        departmentRepository.deleteByDepartmentName(departmentName);		
		}
	}
	
}
