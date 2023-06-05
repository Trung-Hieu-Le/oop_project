package com.home_project.oop_project.controllers.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.home_project.oop_project.entity.Order;
import com.home_project.oop_project.service.OrderService;

@Controller
public class HomeOrderController {
	@Autowired
	private OrderService orderService;

    @GetMapping("/order")
	public String order(Model model) {
		return "home/order";
	}

	@PostMapping("/order/add")
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.saveOrder(order);
		return "redirect:/order";
	}
}
