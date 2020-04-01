package com.administratorportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.administratorportal.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);


}
