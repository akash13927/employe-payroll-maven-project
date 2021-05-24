package com.employee.payrole.services;

import java.util.List;

import com.employee.payrole.entites.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(long employeeId);
	public Employee createEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(long employee);

}
