package com.employee.payrole.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.employee.payrole.dto.EmployeeDto;
import com.employee.payrole.entites.Employee;

@Component
public class EmployeeConverter {
	public EmployeeDto entityTODto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setName(employee.getName());
		employeeDto.setSalary(employee.getSalary());
		//employeeDto.setEmp_phone_no(employee.getEmp_phone_no());
		//employeeDto.setEmp_phone_no(employee.getEmp_phone_no());
		employeeDto.setEmpAddress(employee.getEmpAddress());
		return employeeDto;
	}
	
	public List<EmployeeDto> entityTODto(List<Employee> employee) {
		return employee.stream().map(x -> entityTODto(x)).collect(Collectors.toList());
	}

	public Employee dtotoEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setSalary(employeeDto.getSalary());
		employee.setEmp_phone_no(employee.getEmp_phone_no());
		employee.setEmpAddress(employeeDto.getEmpAddress());
		return employee;
	}
	public List<Employee> dtotoEntity(List<EmployeeDto> employeeDto) {
		return employeeDto.stream().map(x -> dtotoEntity(x)).collect(Collectors.toList());
	}
}
