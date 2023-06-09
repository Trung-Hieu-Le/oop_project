package com.home_project.oop_project.service;

import java.util.List;

import com.home_project.oop_project.entity.User;

public interface UserService {

	List<User> getAllUsers();

    List<User> getAllUsers(String keyword, int pageNo, int pageSize);

	User validationUser(String username, String password);

	User findUserByUsername(String username);
	
	int getTotalItems(String keyword);

	User saveUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUserById(Long id);
}

