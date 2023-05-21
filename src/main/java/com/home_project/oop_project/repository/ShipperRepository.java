package com.home_project.oop_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home_project.oop_project.entity.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    @Query(value = "SELECT * FROM shippers WHERE CONCAT(name, ' ', dia_chi,' ', sdt, ' ',email, ' ', cccd) LIKE %?1%  ORDER BY id DESC", nativeQuery = true)
    public List<Shipper> search(String keyword);

}
