package com.home_project.oop_project.controllers.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.home_project.oop_project.entity.Admin;
import com.home_project.oop_project.service.AdminService;
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
	private AdminService adminService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShipperService shipperService;
	@Autowired
	private UserService userService;

	// int adminlogcheck = 0;
	// String usernameforclass = "";
	private Admin adminNameValidated;

	@GetMapping("/login")
	public String adminLogin(Model model) {

		return "admin/adminLogin";
	}

	@GetMapping("")
	public String adminHome(Model model) {
		if (adminNameValidated != null) {
			model.addAttribute("adminNameValidated", adminNameValidated);
			model.addAttribute("totalShipper", shipperService.getTotalItems(null));
			model.addAttribute("totalOrder", orderService.getTotalItems(null));
			model.addAttribute("totalUser", userService.getTotalItems(null));
			model.addAttribute("listOrders", orderService.getAllOrders(null, 0, 10));
			model.addAttribute("listShippers", shipperService.getAllShippers(null, 0, 10));
			model.addAttribute("orderStatusCount", orderService.getReportByStatus());
			model.addAttribute("orderShipperCount", orderService.getReportByShipper());
			return "admin/adminHome";
		} else
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
	public String adminLogin(@RequestParam("name") String name, @RequestParam("password") String pass, Model model) {

		try {

			Admin admin1 = adminService.validationAdmin(name, pass);
			if (admin1 == null) {
				model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không hợp lệ");
				return "admin/adminLogin";

			} else {
				adminNameValidated = admin1;
				return "redirect:/admin";
			}

		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return "admin/adminLogin";
	}

	@PostMapping("/admin-register")
	public String newAdminRegister(@ModelAttribute("admin") Admin admin, Model model) {
		// try {
		// 	adminService.saveAdmin(admin);

		// } catch (Exception e) {
		// 	System.out.println("Exception:" + e);
		// }
		// return "redirect:/admin";
		try
		{
			if (adminService.findAdminByUsername(admin.getName()) == null) adminService.saveAdmin(admin);
			else {
				model.addAttribute("message", "Tên đăng nhập đã tồn tại");
				return "admin/adminRegister";
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/";
	}

}
