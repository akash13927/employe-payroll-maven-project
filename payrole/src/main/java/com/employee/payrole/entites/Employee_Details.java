package com.employee.payrole.entites;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table
public class Employee_Details {
	@Id
	private int id;
	private String name;
	private String emp_address;
	private String date_of_birth;
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "emp_details")
	private Employee employee;
	
	public Employee_Details() {};
	public Employee_Details(int id, String name, String emp_address, String date_of_birth, Employee employee) {
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

}
