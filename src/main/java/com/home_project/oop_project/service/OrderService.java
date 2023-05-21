package com.home_project.oop_project.service;

import java.util.List;

import com.home_project.oop_project.entity.Order;

public interface OrderService {
    List<Order> getAllOrders(String keyword, int pageNo, int pageSize);
	
	Order saveOrder(Order order);
	
	Order getOrderById(Long id);
	
	Order updateOrder(Order order);
	
	void deleteOrderById(Long id);

}
