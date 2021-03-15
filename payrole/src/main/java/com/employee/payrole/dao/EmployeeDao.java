package com.employee.payrole.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.payrole.entites.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
