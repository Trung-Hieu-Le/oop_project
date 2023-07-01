package com.home_project.oop_project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.home_project.oop_project.entity.Order;

public interface OrderRepository extends  JpaRepository<Order, Long> {

    @Query(
        value="SELECT * FROM orders WHERE CONCAT(end_point, ' ', start_point, ' ', created_at, ' ', ghi_chu, ' ', status, ' ',good_name) LIKE %?1% ORDER BY id DESC LIMIT ?2,?3",
        nativeQuery=true)
    public List<Order> search(String keyword, int offset, int pageSize);

    @Query(
        value="SELECT count(id) FROM orders",
        nativeQuery=true)
    public int getTotalItems();

    @Query(
        value="SELECT count(id) FROM orders WHERE CONCAT(end_point, ' ', start_point, ' ', created_at, ' ', ghi_chu, ' ', status, ' ',good_name) LIKE %?1%",
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
        value="SELECT DISTINCT users.username, count(orders.id) FROM orders join users on orders.user_id= users.id group by users.username",
        nativeQuery =true
    )
    public List<Object> reportByValue();

    @Query(
        value="SELECT * FROM orders where created_at between ?1 and ?2",
        nativeQuery =true
    )
    public List<Order> reportInMonth(String startDate, String endDate);

    @Query(
        value="SELECT count(*) FROM orders where created_at between ?1 and ?2",
        nativeQuery =true
    )
    public int reportCountInMonth(String startDate, String endDate);

    @Query(
        value="select status,count(id) from orders where created_at between ?1 and ?2 group by status",
        nativeQuery=true
    )
    public List<Object> reportByStatusInMonth(String startDate, String endDate);

    @Query(
        value="select status,count(id) from orders where created_at = ?1 group by status",
        nativeQuery=true
    )
    public List<Object> reportByStatusToday(String date);

    @Query(
        value="select shippers.fullname, count(orders.id) from orders join shippers on orders.shipper_id= shippers.id where created_at = ?1 group by orders.shipper_id",
        nativeQuery =true
    )
    public List<Object> reportByShipperToday(String date);

    @Query(
        value="SELECT DISTINCT users.username, count(orders.id) FROM orders join users on orders.user_id= users.id where created_at = ?1 group by users.username",
        nativeQuery =true
    )
    public List<Object> reportByValueToday(String date);
}
