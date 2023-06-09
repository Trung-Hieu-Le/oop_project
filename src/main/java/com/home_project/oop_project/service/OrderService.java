package com.home_project.oop_project.service;

import java.util.List;

import com.home_project.oop_project.entity.Order;

public interface OrderService {
    List<Order> getAllOrders(String keyword, int pageNo, int pageSize);

	int getTotalItems(String keyword);
	
	List<Object> getReportByStatus();

	List<Object> getReportByShipper();

	List<Object> getReportByValue();

	List<Object> getReportByStatusToday(String date);

	List<Object> getReportByShipperToday(String date);

	List<Object> getReportByValueToday(String date);

	List<Order> getReportInMonth(String startDate, String endDate);

	int getReportCountInMonth(String startDate, String endDate);

	List<Object> getReportByStatusInMonth(String startDate, String endDate);

	Order saveOrder(Order order);
	
	Order getOrderById(Long id);
	
	Order updateOrder(Order order);
	
	void deleteOrderById(Long id);

}
