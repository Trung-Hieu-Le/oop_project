package com.home_project.oop_project.service.impl;

import org.springframework.stereotype.Service;

import com.home_project.oop_project.entity.Admin;
import com.home_project.oop_project.repository.AdminRepository;
import com.home_project.oop_project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
	public Admin validationAdmin(String name, String password) {
		// throw new UnsupportedOperationException("Unimplemented method 'validationUser'");
		return adminRepository.validationAdmin(name, password);
	}

	@Override
	public Admin findAdminByUsername(String name) {
		// throw new UnsupportedOperationException("Unimplemented method 'validationUser'");
		return adminRepository.findAdminByUsername(name);
	}

}
