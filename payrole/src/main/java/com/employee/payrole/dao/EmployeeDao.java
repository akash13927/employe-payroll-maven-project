package com.employee.payrole.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.payrole.entites.Employee;
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByName(String name);
}
