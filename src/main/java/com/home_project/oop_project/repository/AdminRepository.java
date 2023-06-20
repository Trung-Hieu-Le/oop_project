package com.home_project.oop_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home_project.oop_project.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
     @Query(
        value="SELECT * FROM admins WHERE name = ?1 and password = ?2 limit 1",
        nativeQuery=true)
    public Admin validationAdmin(String name, String password);

     @Query(
        value="SELECT * FROM admins WHERE name = ?1 limit 1",
        nativeQuery=true)
    public Admin findAdminByUsername(String name);
}
