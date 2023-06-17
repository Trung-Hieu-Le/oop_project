package com.home_project.oop_project.controllers.home;

import java.util.Calendar;
import java.util.Date;

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
		Date currentDate = Calendar.getInstance().getTime();
		Order order0 = new Order(order.getStartPoint(), order.getEndPoint(), order.getGoodName(), order.getGoodType(), order.getGoodWeight(),
		 order.getCustomerName(),0, 0, "Chờ xử lí", currentDate, order.getGhiChu());
		orderService.saveOrder(order0);
		return "redirect:/order";
	}
}
