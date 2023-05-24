package com.home_project.oop_project.controllers;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home_project.oop_project.entity.Order;
import com.home_project.oop_project.service.OrderService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {
    private OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	// handler method to handle list orders and return mode and view
	@GetMapping("/{pageNo}")
	public String listOrders(Model model, @Param("keyword") String keyword, @PathVariable int pageNo) {
		pageNo--;
		int pageSize=10;
		int totalItems= orderService.getAllOrders(keyword, 0,9999).size();
		int totalPages;
		if (totalItems!=0){
			if(totalItems%pageSize==0) {totalPages= totalItems / pageSize;}
			else {totalPages= totalItems / pageSize + 1;}
		}
		else {totalPages=1;}
		List<Order> listOrders = orderService.getAllOrders(keyword, pageNo, pageSize);
		listOrders.size();
		model.addAttribute("orders", listOrders);
        model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", pageNo+1);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("totalItems", totalItems);
		// model.addAttribute("orders", orderService.getAllOrders(keyword));
		 return "admin/adminOrder";
	}
	
	@GetMapping("/new")
	public String createOrderForm(Model model) {
		
		// create order object to hold order form data
		Order order = new Order();
		model.addAttribute("order", order);
		return "admin/addOrder";
		
	}
	
	@PostMapping("/add")
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.saveOrder(order);
		return "redirect:/admin/order/1";
	}
	
	@GetMapping("/edit/{id}")
	public String editOrderForm(@PathVariable Long id, Model model) {
		model.addAttribute("order", orderService.getOrderById(id));
		return "admin/editOrder";
	}

	@PostMapping("/update/{id}")
	public String updateOrder(@PathVariable Long id,
			@ModelAttribute("order") Order order,
			Model model) {
		
		// get order from database by id
		Order existingOrder = orderService.getOrderById(id);
		existingOrder.setId(id);
		existingOrder.setStartPoint(order.getStartPoint());
		existingOrder.setEndPoint(order.getEndPoint());
		existingOrder.setValue(order.getValue());
		existingOrder.setShipperID(order.getShipperID());
		existingOrder.setStatus(order.getStatus());
		
		// save updated order object
		orderService.updateOrder(existingOrder);
		return "redirect:/admin/order/1";
	}
	
	// handler method to handle delete order request
	
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrderById(id);
		return "redirect:/admin/order/1";
	}
	
}