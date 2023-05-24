package com.home_project.oop_project.controllers;

import java.sql.*;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
	@GetMapping(value = {"about"})
	public String about(Model model) {
		return "home/about";
	}
	@GetMapping(value = {"order"})
	public String order(Model model) {
		return "home/order";
	}
	@GetMapping(value = {"join"})
	public String join(Model model) {
		return "home/join";
	}
	
	int adminlogcheck = 0;
	String usernameforclass = "";
	
	
	@GetMapping("login")
	public String userLogin(Model model) {
		return "home/userLogin";
	}
	@GetMapping("/")
	public String Home(Model model) {
			model.addAttribute("username", usernameforclass);
			return "home/home";
	}

	@GetMapping("/register")
	public String registerUser()
	{
		return "home/register";
	}
	// @GetMapping("user-login")
	// public String adminLog(Model model) {
		
	// 	return "home/userLogin";  
	// }
	// @RequestMapping(value = "user-login", method = RequestMethod.POST)
	// public String userLogin( @RequestParam("username") String username, @RequestParam("password") String pass,Model model) {
		
	// 	try
	// 	{
	// 		Class.forName("com.mysql.jdbc.Driver");
	// 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","");
	// 		Statement stmt = con.createStatement();
	// 		ResultSet rst = stmt.executeQuery("select * from users where name = '"+username+"' and password = '"+ pass+"' ;");
	// 		if(rst.next()) {
	// 			usernameforclass = rst.getString(2);
	// 			return "redirect:/";
	// 			}
	// 		else {
	// 			model.addAttribute("message", "Invalid Username or Password");
	// 			return "home/userLogin";
	// 		}
			
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		System.out.println("Exception:"+e);
	// 	}
	// 	return "home/userLogin";
		
	// }

	// @RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	// public String newUseRegister(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email)
	// {
	// 	try
	// 	{
	// 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","");
	// 		PreparedStatement pst = con.prepareStatement("insert into users(username,password,email) values(?,?,?);");
	// 		pst.setString(1,username);
	// 		pst.setString(2, password);
	// 		pst.setString(3, email);
	// 		//pst.setString(4, address);
	// 		int i = pst.executeUpdate();
	// 		System.out.println("data base updated"+i);
			
	// 	}
	// 	catch(Exception e)
	// 	{
	// 		System.out.println("Exception:"+e);
	// 	}
	// 	return "redirect:/";
	// }

}
