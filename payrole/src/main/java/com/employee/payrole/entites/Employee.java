package com.employee.payrole.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	private int id;
	private String name;
	private long salary;
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name="EmployeeAndEmpNo",joinColumns = {@JoinColumn(name="Emp_Id")},
	inverseJoinColumns = {@JoinColumn(name="Emp_No_Id")})
	private Set<Emp_Phone_No>  emp_phone_no = new HashSet<Emp_Phone_No>();
	private String empAddress;
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Employee() {
		super();
		
	}
	
	public Employee(int id, String name, long salary, Set<Emp_Phone_No> emp_phone_no, String empAddress) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.emp_phone_no = emp_phone_no;
		this.empAddress = empAddress;
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Set<Emp_Phone_No> getEmp_phone_no() {
		return emp_phone_no;
	}
	public void setEmp_phone_no(Set<Emp_Phone_No> emp_phone_no) {
		this.emp_phone_no = emp_phone_no;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", emp_phone_no=" + emp_phone_no + "]";
	}
	
	
	
	

}
