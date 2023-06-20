package com.home_project.oop_project.service;

import com.home_project.oop_project.entity.Admin;

public interface AdminService {
    Admin saveAdmin(Admin admin);
	
	Admin getAdminById(Long id);

	Admin validationAdmin(String username, String password);

	Admin findAdminByUsername(String username);
	
}
