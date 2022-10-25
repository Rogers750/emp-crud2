package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Employee;

public interface employeeService {
	
    public Employee findById(int id);
	
	public void deleteById(int id);
	
	public List<Employee> findAll();
	
	public void save(Employee emp);

}
