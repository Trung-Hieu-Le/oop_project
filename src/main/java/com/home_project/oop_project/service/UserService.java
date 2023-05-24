package com.home_project.oop_project.service;

import java.util.List;

import com.home_project.oop_project.entity.User;

public interface UserService {
    List<User> getAllUsers(String keyword, int pageNo, int pageSize);
	
	User saveUser(User user);
	
	User getUserById(Long id);
	
	User updateUser(User user);
	
	void deleteUserById(Long id);
}

