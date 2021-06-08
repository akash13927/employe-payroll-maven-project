package com.employee.payrole.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.payrole.dao.Employee_Phone_NoDao;
import com.employee.payrole.entites.Emp_Phone_No;
import com.employee.payrole.services.Employee_Phone_No_Service;
@Service
public class Employee_Phone_No_Service_Impl implements Employee_Phone_No_Service{
	@Autowired
	private Employee_Phone_NoDao emp_Dao;
	@Override
	public List<Emp_Phone_No> get_All_Employees_Phone_No() {
		return emp_Dao.findAll();
		
	}

	@Override
	public Emp_Phone_No get_Employee_Phone_No(int emp_Id) {
		return this.emp_Dao.getOne(emp_Id);
	}

	@Override
	public Emp_Phone_No add_Emp_Phone_No(Emp_Phone_No emp_Phone_No) {
		emp_Dao.save(emp_Phone_No);
		return emp_Phone_No;
	}

	@Override
	public Emp_Phone_No update_Emp_Phone_No(Emp_Phone_No emp_Phone_No) {
		emp_Dao.save(emp_Phone_No);
		return emp_Phone_No;
	}

	@Override
	public void deleteEmployee_Phone_No(int employee_Phone_No_Id) {
		Emp_Phone_No emp = emp_Dao.getOne(employee_Phone_No_Id);
		emp_Dao.delete(emp);
	}

}
