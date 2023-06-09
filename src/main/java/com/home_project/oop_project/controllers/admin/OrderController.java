package com.home_project.oop_project.controllers.admin;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home_project.oop_project.entity.Order;
import com.home_project.oop_project.entity.Shipper;
import com.home_project.oop_project.entity.User;
import com.home_project.oop_project.service.OrderService;
import com.home_project.oop_project.service.ShipperService;
import com.home_project.oop_project.service.UserService;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

	@Autowired
    private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShipperService shipperService;

	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	// handler method to handle list orders and return mode and view
	@GetMapping("/{pageNo}")
	public String listOrders(Model model, @Param("keyword") String keyword, @PathVariable int pageNo) {
		int pageSize=10;
		int totalItems= orderService.getTotalItems(keyword);
		int totalPages;
		if (totalItems!=0){
			if(totalItems%pageSize==0) {totalPages= totalItems / pageSize;}
			else {totalPages= totalItems / pageSize + 1;}
		}
		else {totalPages=1;}
		List<Order> listOrders = orderService.getAllOrders(keyword, pageNo-1, pageSize);
		listOrders.size();
		model.addAttribute("orders", listOrders);
        model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", pageNo);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("totalItems", totalItems);
		// model.addAttribute("orders", orderService.getAllOrders(keyword));
		 return "admin/adminOrder";
	}
	
	@GetMapping("/new")
	public String createOrderForm(Model model) {
		
		// create order object to hold order form data
		Order order = new Order();
		List<User> listUsers = userService.getAllUsers();
		List<Shipper> listShippers = shipperService.getAllShippers();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("listShippers", listShippers);
		model.addAttribute("order", order);
		return "admin/addOrder";
		
	}
	
	@PostMapping("/add")
	public String saveOrder(@ModelAttribute("order") Order order) {
		// orderService.saveOrder(order);
		Date currentDate = Calendar.getInstance().getTime();
		Order order0 = new Order(order.getStartPoint(), order.getEndPoint(), order.getGoodName(), order.getGoodType(), order.getGoodWeight(),
		 order.getCustomerName(),order.getUser(), order.getShipper(), order.getStatus(), currentDate, order.getGhiChu());
		orderService.saveOrder(order0);
		return "redirect:/admin/order/1";
	}
	
	@GetMapping("/edit/{id}")
	public String editOrderForm(@PathVariable Long id, Model model) {
		List<User> listUsers = userService.getAllUsers();
		List<Shipper> listShippers = shipperService.getAllShippers();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("listShippers", listShippers);
		model.addAttribute("order", orderService.getOrderById(id));
		return "admin/editOrder";
	}

	@PostMapping("/update/{id}")
	public String updateOrder(@PathVariable Long id, @ModelAttribute("order") Order order, Model model) {
		
		// Date currentDate = Calendar.getInstance().getTime();
		Order existingOrder = orderService.getOrderById(id);
		existingOrder.setId(id);
		existingOrder.setStartPoint(order.getStartPoint());
		existingOrder.setEndPoint(order.getEndPoint());
		existingOrder.setCustomerName(order.getCustomerName());
		existingOrder.setUser(order.getUser());
		existingOrder.setShipper(order.getShipper());
		// existingOrder.setCreatedAt(currentDate);
		existingOrder.setGoodName(order.getGoodName());
		existingOrder.setGoodType(order.getGoodType());
		existingOrder.setGoodWeight(order.getGoodWeight());
		existingOrder.setStatus(order.getStatus());
		existingOrder.setGhiChu(order.getGhiChu());
		
		// save updated order object
		orderService.updateOrder(existingOrder);
		return "redirect:/admin/order/1";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrderById(id);
		return "redirect:/admin/order/1";
	}
	
}
