package com.employee.payrole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.payrole.entites.Employee_Details;
@Repository

public interface Employee_DetailsDao extends
		JpaRepository<Employee_Details, Integer>{
	
}
