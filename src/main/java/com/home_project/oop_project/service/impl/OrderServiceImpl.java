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
            return orderRepository.search(keyword);
        }
        return orderRepository.findAll(pageable).get().toList();
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



	
}
