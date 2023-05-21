package com.home_project.oop_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.home_project.oop_project.entity.Order;

public interface OrderRepository extends  JpaRepository<Order, Long> {

@Query(
    value="SELECT * FROM orders WHERE CONCAT(end_point, ' ', shipper_id, ' ', start_point, ' ', status, ' ',value) LIKE %?1% ORDER BY id DESC",
    nativeQuery=true)
public List<Order> search(String keyword);
}
