package com.employee.payrole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.employee.payrole.dao.UserRepository;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class PayroleApplication {

	public static void main(String[] args) {
		//ApplicationContext context1 = (ApplicationContext) 
		SpringApplication.run(PayroleApplication.class, args);
		
	}

}
