package com.employee.payrole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.payrole.entites.Emp_Phone_No;
@Repository
public interface Employee_Phone_NoDao extends JpaRepository<Emp_Phone_No, Integer>{

}
