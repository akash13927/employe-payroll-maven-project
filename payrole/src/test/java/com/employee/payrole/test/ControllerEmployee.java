package com.employee.payrole.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employee.payrole.dao.UserRepository;
import com.employee.payrole.entites.Employee;
import com.employee.payrole.services.EmployeeService;


@SpringBootTest
class ControllerEmployee {
	@Autowired
	private EmployeeService employeeService;
	@MockBean
    private UserRepository repository;
	
	@Test
	public void getAllEmployeetest() {
		//List<Employee> list = employeeService.getEmployees();
		String s = employeeService.getEmployee(1).getName();
		assertEquals( s , "vikas");
		//fail("Not yet implemented");
	}

}
