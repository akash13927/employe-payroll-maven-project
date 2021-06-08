package com.employee.payrole.services;

import java.util.List;

import com.employee.payrole.entites.Emp_Phone_No;

public interface Employee_Phone_No_Service {
	public List<Emp_Phone_No> get_All_Employees_Phone_No();
	public Emp_Phone_No get_Employee_Phone_No(int emp_Id);
	public Emp_Phone_No add_Emp_Phone_No(Emp_Phone_No emp_Phone_No);
	public Emp_Phone_No update_Emp_Phone_No(Emp_Phone_No emp_Phone_No);
	public void deleteEmployee_Phone_No(int employee_Phone_No_Id);
}
