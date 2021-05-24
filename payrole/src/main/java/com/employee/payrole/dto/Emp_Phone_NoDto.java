package com.employee.payrole.dto;

import java.util.Set;

import com.employee.payrole.entites.Employee;

public class Emp_Phone_NoDto {
	private int id;
	private String office_Num;
	private String personal_Num;
	private Set<Employee> employee;
	
	
	public Emp_Phone_NoDto(int id, String office_Num, String personal_Num, Set<Employee> employee) {
		super();
		this.id = id;
		this.office_Num = office_Num;
		this.personal_Num = personal_Num;
		this.employee = employee;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOffice_Num() {
		return office_Num;
	}
	public void setOffice_Num(String office_Num) {
		this.office_Num = office_Num;
	}
	public String getPersonal_Num() {
		return personal_Num;
	}
	public void setPersonal_Num(String personal_Num) {
		this.personal_Num = personal_Num;
	}
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	public Emp_Phone_NoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Emp_Phone_NoDto [id=" + id + ", office_Num=" + office_Num + ", personal_Num=" + personal_Num
				+ ", employee=" + employee + "]";
	}

}
