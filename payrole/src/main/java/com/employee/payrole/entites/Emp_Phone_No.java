package com.employee.payrole.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Emp_Phone_No {
	@Id
	private int id;
	private String office_Num;
	private String personal_Num;
	@ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "emp_phone_no")
	private Set<Employee> employee = new HashSet<Employee>();
	
	public Emp_Phone_No(int id, String office_Num, String personal_Num, Set<Employee> employee) {
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
	public Emp_Phone_No() {
		super();
	}
	@Override
	public String toString() {
		return "Emp_Phone_No [id=" + id + ", office_Num=" + office_Num + ", personal_Num=" + personal_Num
				+ ", employee=" + employee + "]";
	}
	

}
