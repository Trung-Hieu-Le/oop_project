package com.home_project.oop_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home_project.oop_project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
    
}
