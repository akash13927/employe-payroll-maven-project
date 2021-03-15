package com.employee.payrole.myController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.payrole.entites.Employee;

import com.employee.payrole.services.EmployeeService;
@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId){
		return this.employeeService.getEmployee(Long.parseLong(employeeId));
	}
	
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeService.createEmployee(employee);
		
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return this.employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable String employeeId) {
		try {
			this.employeeService.deleteEmployee(Long.parseLong(employeeId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 
	}
}




