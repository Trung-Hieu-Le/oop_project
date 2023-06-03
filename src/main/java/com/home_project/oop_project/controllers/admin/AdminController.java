package com.home_project.oop_project.controllers.admin;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.home_project.oop_project.entity.Admin;
import com.home_project.oop_project.service.AdminService;

import java.sql.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	int adminlogcheck = 0;
	String usernameforclass = "";

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
	public String adminLogin( @RequestParam("name") String username, @RequestParam("password") String pass,Model model) {
		
		// if(username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")) {
		// 	adminlogcheck=1;
		// 	return "redirect:/admin";
		// 	}
		// else {
		// 	model.addAttribute("message", "Invalid Username or Password");
		// 	return "admin/adminLogin";
		// }
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from admins where name = '"+username+"' and password = '"+ pass+"' ;");
			if(rst.next()) {
				usernameforclass = rst.getString(2);
				return "redirect:/admin";
				}
			else {
				model.addAttribute("message", "Invalid Username or Password");
				return "home/adminLogin";
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "home/adminLogin";
	}

	@PostMapping("/admin-register")
	public String newAdminRegister(@ModelAttribute("admin") Admin admin)
	{
		try
		{
			adminService.saveAdmin(admin);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/admin";
	}

}
