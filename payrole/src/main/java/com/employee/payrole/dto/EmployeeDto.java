package com.employee.payrole.dto;

public class EmployeeDto {
	private int id;
	private String name;
	private long salary;
	private long emp_phone_no;
	private String empAddress;
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public long getEmp_phone_no() {
		return emp_phone_no;
	}
	public void setEmp_phone_no(long emp_phone_no) {
		this.emp_phone_no = emp_phone_no;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

}
