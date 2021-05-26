package com.employee.payrole.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.payrole.dao.EmployeeDao;
import com.employee.payrole.entites.Employee;
import com.employee.payrole.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	List<Employee> list = null;
	
	 public EmployeeServiceImpl() {
		list = new ArrayList<Employee>();
	
	}

	

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployee(long employeeId) {
		return employeeDao.getOne(employeeId);
		//		Employee e=null;
//		for(Employee emp:list) {  
//			if(emp.getId() == employeeId ) {
//				e=emp;
//				break;
//			}
//		}
//		return e;
	}



	@Override
	public Employee createEmployee(Employee employee) {
//		list.add(employee);
		employeeDao.save(employee);
		return employee;
	}



	@Override
	public Employee updateEmployee(Employee employee) {
//		Employee emp=null;
//		for(Employee e:list) {
//			if( e.getId() == employee.getId() ) {
//				list.remove(e);
//				list.add(employee);
//				emp = employee;
//				break;
//			}
//		}
		employeeDao.save(employee);
		return employee;
	}



	@Override
	public void deleteEmployee(long employeeId) {
		Employee entity = employeeDao.getOne(employeeId) ;
		employeeDao.delete(entity);
	}

//
//	public Employee deleteEmployee(Long employee) {
////		Employee emp = null;
////		for(Employee e:list) {
////			if(e.getId() == employee){
////				list.remove(e);
////				emp=e;
////			}
////			}
//	}

}
