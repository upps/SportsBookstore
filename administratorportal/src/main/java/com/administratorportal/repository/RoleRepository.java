package com.administratorportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.administratorportal.domain.security.Role;



public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByname(String name);
}
