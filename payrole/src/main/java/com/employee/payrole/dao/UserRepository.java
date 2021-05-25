package com.employee.payrole.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.payrole.entites.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String username);

}
