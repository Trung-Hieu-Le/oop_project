package com.home_project.oop_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home_project.oop_project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
@Query(
    value="SELECT * FROM users WHERE CONCAT(name, ' ', dia_chi,' ', sdt, ' ',email) LIKE %?1%  ORDER BY id DESC",
    nativeQuery=true)
public List<User> search(String keyword); 

}
