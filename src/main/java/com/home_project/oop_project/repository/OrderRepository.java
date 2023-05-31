package com.home_project.oop_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.home_project.oop_project.entity.Order;

public interface OrderRepository extends  JpaRepository<Order, Long> {

    @Query(
        value="SELECT * FROM orders WHERE CONCAT(end_point, ' ', customer_name, ' ', start_point, ' ', status, ' ',value) LIKE %?1% ORDER BY id DESC LIMIT ?2,?3",
        nativeQuery=true)
    public List<Order> search(String keyword, int offset, int pageSize);

    @Query(
        value="SELECT count(id) FROM orders",
        nativeQuery=true)
    public int getTotalItems();

    @Query(
        value="SELECT count(id) FROM orders WHERE CONCAT(end_point, ' ', customer_name, ' ', start_point, ' ', status, ' ',value) LIKE %?1%",
        nativeQuery=true)
    public int getTotalItemsSearched(String keyword);

    @Query(
        value="select status,count(id) from orders group by status",
        nativeQuery=true
    )
    public List<Object> reportByStatus();

    @Query(
        value="select shippers.fullname, count(orders.id) from orders join shippers on orders.shipper_id= shippers.id group by orders.shipper_id",
        nativeQuery =true
    )
    public List<Object> reportByShipper();

    @Query(
        value="SELECT DISTINCT end_point, count(id), SUM(value) FROM orders group by end_point",
        nativeQuery =true
    )
    public List<Object> reportByValue();

    @Query(
        value="SELECT * FROM orders where date between '?2-?1-01' and '?2-?1-31'",
        nativeQuery =true
    )
    public List<Object> reportByMonth();
}
