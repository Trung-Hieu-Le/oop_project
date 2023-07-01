package com.home_project.oop_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.home_project.oop_project.entity.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Long> {
    @Query(
        value = "SELECT * FROM shippers WHERE CONCAT(fullname, ' ', dia_chi,' ', sdt, ' ',email) LIKE %?1% ORDER BY id DESC LIMIT ?2,?3",
        nativeQuery = true)
    public List<Shipper> search(String keyword, int offset, int pageSize);

    @Query(
        value="SELECT count(id) FROM shippers",nativeQuery=true)
    public int getTotalItems();
    
    @Query(
        value="SELECT count(id) FROM shippers WHERE CONCAT(fullname, ' ', dia_chi,' ', sdt, ' ',email) LIKE %?1%",
        nativeQuery=true)
    public int getTotalItemsSearched(String keyword);
}
