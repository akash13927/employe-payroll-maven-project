package com.employee.payrole.entites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	private int id;
	private String name;
	private long salary;
	private long emp_phone_no;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, long salary, long emp_phone_no) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.emp_phone_no = emp_phone_no;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", emp_phone_no=" + emp_phone_no + "]";
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
	

}
