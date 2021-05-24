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

import com.employee.payrole.converter.EmployeeConverter;
import com.employee.payrole.dto.EmployeeDto;
import com.employee.payrole.entites.Employee;

import com.employee.payrole.services.EmployeeService;
@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeConverter employeeConverter;
	@GetMapping("/home")
	public String home() {
		return "Home";
	}
	@GetMapping("/employees")
	public List<EmployeeDto> getEmployees(){
		List<Employee> findAll = employeeService.getEmployees();
		return employeeConverter.entityTODto(findAll);
	}
	
	@GetMapping("/employee/{employeeId}")
	public EmployeeDto getEmployee(@PathVariable String employeeId){
		Employee findOne = employeeService.getEmployee(Long.parseLong(employeeId));
		return employeeConverter.entityTODto(findOne);
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody EmployeeDto employee) {
		Employee emp =  employeeConverter.dtotoEntity(employee);
		return this.employeeService.createEmployee(emp);
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody EmployeeDto employee) {
		Employee emp = employeeConverter.dtotoEntity(employee);
		return this.employeeService.updateEmployee(emp);
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




