package com.employee.payrole.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.employee.payrole.dto.Emp_Phone_NoDto;
import com.employee.payrole.entites.Emp_Phone_No;

@Component
public class Emp_Phone_NoConverter {
	public Emp_Phone_NoDto entityToDto(Emp_Phone_No emp) {
		Emp_Phone_NoDto emp_dto = new Emp_Phone_NoDto();
		emp_dto.setId(emp.getId());
		emp_dto.setOffice_Num(emp.getOffice_Num());
		emp_dto.setPersonal_Num(emp.getPersonal_Num());
		emp_dto.setEmployee(emp.getEmployee());
		return emp_dto;
	}
	public List<Emp_Phone_NoDto> entityToDto(List<Emp_Phone_No> emp){
		return emp.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	}
	
	public Emp_Phone_No DtoToentity(Emp_Phone_NoDto empDto) {
		Emp_Phone_No emp = new Emp_Phone_No();
		emp.setId(empDto.getId());
		emp.setOffice_Num(empDto.getOffice_Num());
		emp.setPersonal_Num(empDto.getPersonal_Num());
		emp.setEmployee(empDto.getEmployee());
		return emp;
	}
	public List<Emp_Phone_No> DtoToentity(List<Emp_Phone_NoDto> empDto) {
		return empDto.stream().map(x -> DtoToentity(x)).collect(Collectors.toList());
	}
}




