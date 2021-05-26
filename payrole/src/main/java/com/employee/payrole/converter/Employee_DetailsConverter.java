package com.employee.payrole.converter;

import java.util.List;
import java.util.stream.Collectors;

import com.employee.payrole.dto.Emp_Phone_NoDto;
import com.employee.payrole.dto.Employee_DetailsDto;
import com.employee.payrole.entites.Emp_Phone_No;
import com.employee.payrole.entites.Employee_Details;

public class Employee_DetailsConverter {
	
	public Employee_DetailsDto entityToDto(Employee_Details emp) {
		Employee_DetailsDto empDto = new Employee_DetailsDto();
		empDto.setId(emp.getId());
		empDto.setName(emp.getName());
		empDto.setEmp_address(emp.getEmp_address());
		empDto.setDate_of_birth(emp.getDate_of_birth());
		empDto.setEmployee(emp.getEmployee());
		return empDto;
	}
	public List<Employee_DetailsDto> entityToDto(List<Employee_Details> emp){
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	public Employee_Details dtoToEntity(Employee_DetailsDto empDto) {
		Employee_Details emp = new Employee_Details();
		emp.setId(empDto.getId());
		emp.setName(empDto.getName());
		emp.setEmp_address(empDto.getEmp_address());
		emp.setDate_of_birth(empDto.getDate_of_birth());
		emp.setEmployee(empDto.getEmployee());
		return emp;
	}
	public List<Employee_Details> dtoToEntity(List<Employee_DetailsDto> empDto) {
		return empDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}
}
