package com.example.demo.service;

//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.DAO.EmployeeRepository;
//import com.example.demo.entity.Employee;
//
//@Service
//public class employeeServiceImpl implements employeeService {
//	
//	private EmployeeRepository employeeRepo;
//	
//	public employeeServiceImpl() {
//		
//	}
//	
//	@Autowired
//	public employeeServiceImpl(EmployeeRepository employeeRepo) 
//	{
//		this.employeeRepo=employeeRepo;
//	}
//
//		@Override
//		public Employee findById(int id) {
//		Optional<Employee> result = employeeRepo.findById(id);
//		Employee emp=null;
//		if(result.isPresent()) {
//			emp=result.get();
//		}
//		else {
//			throw new RuntimeException("Could not find the employee Id: "+id);
//		}
//			
//		return emp;
//	}
//
//	@Override
//	public void deleteById(int id) {
//		
//		employeeRepo.deleteById(id);
//
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		
//		return employeeRepo.findAll();
//	}
//
//	@Override
//	public void save(Employee emp) {
//		employeeRepo.save(emp);
//	}
//
//}


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.EmployeeRepository;
import com.example.demo.entity.Employee;

@Service
public class employeeServiceImpl implements employeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public employeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}







