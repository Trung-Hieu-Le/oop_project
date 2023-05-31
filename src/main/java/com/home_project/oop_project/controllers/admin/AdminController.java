package com.home_project.oop_project.controllers.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.home_project.oop_project.service.OrderService;
import com.home_project.oop_project.service.ShipperService;
import com.home_project.oop_project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShipperService shipperService;
	@Autowired
	private UserService userService;


	int adminlogcheck = 0;

	@GetMapping("/login")
	public String adminLogin(Model model) {
		
		return "admin/adminLogin";
	}
	@GetMapping("")
	public String adminHome(Model model) {
		if(adminlogcheck!=0)
			return "admin/adminHome";
		else
			return "redirect:/admin/login";
	}
	@GetMapping("/register")
	public String adminRegister(Model model) {
			return "admin/adminRegister";
		
	}
	@GetMapping("admin-login")
	public String adminLog(Model model) {
		
		return "admin/adminLogin";
	}
	@RequestMapping(value = "admin-login", method = RequestMethod.POST)
	public String adminLogin( @RequestParam("username") String username, @RequestParam("password") String pass,Model model) {
		
		if(username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")) {
			adminlogcheck=1;
			return "redirect:/admin";
			}
		else {
			model.addAttribute("message", "Invalid Username or Password");
			return "admin/adminLogin";
		}
	}


	@GetMapping("thong-ke")
	public String adminThongKe(Model model) {
		model.addAttribute("totalShipper", shipperService.getTotalItems(null));
		model.addAttribute("totalOrder", orderService.getTotalItems(null));
		model.addAttribute("totalUser", userService.getTotalItems(null));
		model.addAttribute("orderStatusCount", orderService.getReportByStatus());
		model.addAttribute("orderShipperCount", orderService.getReportByShipper());
		model.addAttribute("orderValueAndCount", orderService.getReportByValue());

		return "admin/adminThongKe";
	}

	@GetMapping("bao-cao")
	public String adminBaoCao(Model model) {
		
		return "admin/adminBaoCao";
	}
}
