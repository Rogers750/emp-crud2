package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.service.employeeServiceImpl;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	employeeServiceImpl empService;
	
	@Autowired
	public EmployeeController(employeeServiceImpl empServ) {
		empService= empServ;
	}


	
	@GetMapping("/showList")
	public String getAllEmployees(Model theModel){
		
		List<Employee> employees= empService.findAll();
		
		theModel.addAttribute("getAll",employees);
		
		return "listEmployees";
	}
	
	@GetMapping("/showFormForAdd")
	public String addEmployee(Model theModel) {
		Employee emp= new Employee();
		theModel.addAttribute("employee",emp);
		return "employees/showForm";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee emp) {
		empService.save(emp);
		return "redirect:showList";
	}
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("employeeId")int id, Model model) {
		Employee emp=empService.findById(id);
		model.addAttribute("employee",emp);
		return "employees/showForm";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("employeeId")int id) {
		
		empService.deleteById(id);
		return "redirect:showList";
	}

}
