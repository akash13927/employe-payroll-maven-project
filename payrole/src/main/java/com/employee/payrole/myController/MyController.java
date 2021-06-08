package com.employee.payrole.myController;

import java.util.List;

import javax.ws.rs.ext.ExceptionMapper;

import org.hibernate.InvalidMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.employee.payrole.converter.Emp_Phone_NoConverter;
import com.employee.payrole.converter.EmployeeConverter;
import com.employee.payrole.converter.util.JwtUtil;
import com.employee.payrole.services.EmployeeService;
import com.employee.payrole.services.Employee_Phone_No_Service;
import com.employee.payrole.services.MyUserDetailsService;
import com.employee.payrole.dto.Emp_Phone_NoDto;
import com.employee.payrole.dto.EmployeeDto;
import com.employee.payrole.entites.Emp_Phone_No;
import com.employee.payrole.entites.Employee;
import com.employee.payrole.models.AuthenticationRequest;
import com.employee.payrole.models.AuthenticationResponse;

//import com.employee.payrole.filters.JwtRequestFilter;
//import com.employee.payrole.models.AuthenticationRequest;
//import com.employee.payrole.models.AuthenticationResponse;
//import com.employee.payrole.converter.util.JwtUtil;
//import com.employee.payrole.services.MyUserDetailsService;

import exception.DataNotFoundException;
import exception.GenericExceptionMapper;
@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeConverter employeeConverter;
	@Autowired
	private Employee_Phone_No_Service emp_Phone_Service;
	@Autowired
	private Emp_Phone_NoConverter emp_Phone_No_converter;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/employees")
	public List<EmployeeDto> getEmployees(){
		List<Employee> findAll = employeeService.getEmployees();
		List<EmployeeDto> dtoObj= employeeConverter.entityTODto(findAll);
		return dtoObj;
	}
	
	
	@GetMapping("/employee/{employeeId}")
	public EmployeeDto getEmployee(@PathVariable String employeeId){
		EmployeeDto dto =null;
		
			Employee findOne = employeeService.getEmployee(Long.parseLong(employeeId));
			dto =  employeeConverter.entityTODto(findOne);
			if(dto == null) {
				throw new DataNotFoundException("employee with id "+employeeId+" not present ");
			}
		return dto;
		// .orElseThrow(() -> new ResoursceNotFoundException("user not found with id"+userId));
	}
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody EmployeeDto employee) {
		try {
			Employee emp =  employeeConverter.dtotoEntity(employee);
			return this.employeeService.createEmployee(emp);
		}catch(InvalidMappingException e) {
			throw new DataNotFoundException(e.getMessage());
		}
	}
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody EmployeeDto employee) {
		Employee emp = employeeConverter.dtotoEntity(employee);
		Employee updateEmp = null;
		
			 updateEmp = this.employeeService.updateEmployee(emp);
			 if(updateEmp == null) {
					throw new DataNotFoundException("employee with id "+emp.getId()+" not present ");
				}
			
			//throw new ResponseStatusException("No element of id:"+employee.getId()+"found");
			//return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		return updateEmp;
	}

	@DeleteMapping("/employee/{employeeId}")
	public ExceptionMapper<Throwable> deleteEmployee(@PathVariable String employeeId) {
		try {
			this.employeeService.deleteEmployee(Long.parseLong(employeeId));
			return  null ;  
					//ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			throw new DataNotFoundException("employee with id"+employeeId +"not present");
					//ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
	}
	@GetMapping("/employeesPhone")
	public List<Emp_Phone_NoDto> get_All_PhoneNo(){
		List<Emp_Phone_No> findAll = emp_Phone_Service.get_All_Employees_Phone_No();
		List<Emp_Phone_NoDto> dtoObj= emp_Phone_No_converter.entityToDto(findAll);
		return dtoObj;
	}
	@GetMapping("/employeePhone/{employeeId}")
	public Emp_Phone_NoDto getEmployeePhoneNo(@PathVariable String employee_Phone_No_Id) {
		Emp_Phone_NoDto dto = null;
		Emp_Phone_No findOne = emp_Phone_Service.get_Employee_Phone_No(Integer.parseInt(employee_Phone_No_Id));
		dto = emp_Phone_No_converter.entityToDto(findOne);
		if(dto==null) {
			throw new DataNotFoundException("employee phone no with id"+employee_Phone_No_Id+" is not present");
		}
		return dto;
	}
	@PostMapping("/employeePhone")
	public Emp_Phone_No createEmployeePhoneNO(@RequestBody Emp_Phone_NoDto employeePhone) {
		try {
			Emp_Phone_No emp =  emp_Phone_No_converter.DtoToentity(employeePhone);
			return this.emp_Phone_Service.add_Emp_Phone_No(emp);
		}catch(InvalidMappingException e) {
			throw new DataNotFoundException(e.getMessage());
		}
	}
	@PutMapping("/employeePhone")
	public Emp_Phone_No updateEmployeePhoneNo(@RequestBody Emp_Phone_NoDto empPhone)
			{
		Emp_Phone_No emp =emp_Phone_No_converter.DtoToentity(empPhone);
		Emp_Phone_No updateEmp = null;
		updateEmp = this.emp_Phone_Service.update_Emp_Phone_No(emp);
		if(updateEmp==null) {
			throw new DataNotFoundException("employee phone no with id "+emp.getId()+"is not present");
		}
		return updateEmp;
	}
	@DeleteMapping("/employeePhone/{employeeId}")
	public ExceptionMapper<Throwable> deleteEmployeePhoneNo(@PathVariable String employeeId) {
		try {
			this.emp_Phone_Service.deleteEmployee_Phone_No(Integer.parseInt(employeeId));
			return  null ;  
		} catch(Exception e) {
			throw new DataNotFoundException("employee phone no with id "+employeeId +" is not present");
					
		}
				
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
