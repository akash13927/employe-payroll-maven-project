package com.employee.payrole.myController;

import java.util.List;
import java.util.NoSuchElementException;

import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.employee.payrole.converter.EmployeeConverter;
import com.employee.payrole.converter.util.JwtUtil;
import com.employee.payrole.dto.EmployeeDto;
import com.employee.payrole.entites.Employee;
import com.employee.payrole.filters.JwtRequestFilter;
import com.employee.payrole.models.AuthenticationRequest;
import com.employee.payrole.models.AuthenticationResponse;
import com.employee.payrole.services.EmployeeService;
import com.employee.payrole.services.MyUserDetailsService;

import exception.DataNotFoundException;
import exception.GenericExceptionMapper;
@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeConverter employeeConverter;
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
		//return
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
		Employee emp =  employeeConverter.dtotoEntity(employee);
		return this.employeeService.createEmployee(emp);
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
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
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

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/authenticate").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

}




