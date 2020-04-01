package com.administratorportal.service;

import java.util.Set;

import com.administratorportal.domain.User;
import com.administratorportal.domain.security.UserRole;


public interface UserService {

	
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;
	User save(User user);
}
