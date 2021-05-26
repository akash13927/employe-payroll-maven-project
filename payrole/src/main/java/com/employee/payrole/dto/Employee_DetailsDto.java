package com.employee.payrole.dto;


import com.employee.payrole.entites.Employee;

public class Employee_DetailsDto {
	private int id;
	private String name;
	private String emp_address;
	private String date_of_birth;
	private Employee employee;
	public Employee_DetailsDto() {}

	public Employee_DetailsDto(int id, String name, String emp_address, String date_of_birth, Employee employee) {
		super();
		this.id = id;
		this.name = name;
		this.emp_address = emp_address;
		this.date_of_birth = date_of_birth;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Employee_DetailsDto [id=" + id + ", name=" + name + ", emp_address=" + emp_address + ", date_of_birth="
				+ date_of_birth + ", employee=" + employee + "]";
	}
}
