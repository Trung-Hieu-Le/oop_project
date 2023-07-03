package com.home_project.oop_project.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.home_project.oop_project.entity.Order;
import com.home_project.oop_project.repository.OrderRepository;
import com.home_project.oop_project.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
	
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> getAllOrders(String keyword, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
		if (keyword != null) {
            return orderRepository.search(keyword, pageNo*pageSize, pageSize);
        }
        return orderRepository.findAll(pageable).get().toList();
	}

	@Override
	public int getTotalItems(String keyword){
		if (keyword !=null){
			return orderRepository.getTotalItemsSearched(keyword);
		}
		return orderRepository.getTotalItems();
	}

	@Override
	public List<Object> getReportByStatus() {
		return orderRepository.reportByStatus();
	}

	@Override
	public List<Object> getReportByShipper() {
		return orderRepository.reportByShipper();
	}

	@Override
	public List<Object> getReportByValue() {
		return orderRepository.reportByValue();
	}

	@Override
	public List<Order> getReportInMonth(String startDate, String endDate) {
		return orderRepository.reportInMonth(startDate, endDate);
	}

	@Override
	public int getReportCountInMonth(String startDate, String endDate) {
		return orderRepository.reportCountInMonth(startDate, endDate);
	}

	@Override
	public List<Object> getReportByStatusInMonth(String startDate, String endDate) {
		return orderRepository.reportByStatusInMonth(startDate, endDate);
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrderById(Long id) {
		orderRepository.deleteById(id);	
	}

	@Override
	public List<Object> getReportByStatusToday(String date) {
		return orderRepository.reportByStatusToday(date);
	}

	@Override
	public List<Object> getReportByShipperToday(String date) {
		return orderRepository.reportByShipperToday(date);	
	}

	@Override
	public List<Object> getReportByValueToday(String date) {
		return orderRepository.reportByValueToday(date);
		// throw new UnsupportedOperationException("Unimplemented method 'reportByValueToday'");
	}


}
