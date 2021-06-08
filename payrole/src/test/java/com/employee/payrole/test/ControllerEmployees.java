package com.employee.payrole.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.payrole.dao.UserRepository;
import com.employee.payrole.services.EmployeeService;

class ControllerEmployees {
	@Autowired
	private EmployeeService employeeService;
	@MockBean
    private UserRepository repository;
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
