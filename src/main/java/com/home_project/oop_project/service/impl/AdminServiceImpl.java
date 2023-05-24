package com.home_project.oop_project.service.impl;

import org.springframework.stereotype.Service;

import com.home_project.oop_project.entity.Admin;
import com.home_project.oop_project.repository.AdminRepository;
import com.home_project.oop_project.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).get();
    }

}
