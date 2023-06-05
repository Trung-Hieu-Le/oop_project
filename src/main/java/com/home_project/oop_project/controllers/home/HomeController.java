package com.home_project.oop_project.controllers.home;

import java.sql.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.home_project.oop_project.entity.User;
import com.home_project.oop_project.service.UserService;
@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@GetMapping(value = {"about"})
	public String about(Model model) {
		return "home/about";
	}
	
	int adminlogcheck = 0;
	String usernameforclass = "";
	
	
	@GetMapping("login")
	public String userLogin(Model model) {
		return "home/userLogin";
	}
	@GetMapping("/")
	public String Home(Model model) {
		if(usernameforclass!=""){

			model.addAttribute("username", usernameforclass);
			return "home/home";		}
		else
			return "redirect:/login";
			
	}

	@GetMapping("/register")
	public String registerUser()
	{
		return "home/register";
	}
	@GetMapping("user-login")
	public String adminLog(Model model) {
		
		return "home/userLogin";  
	}
	@RequestMapping(value = "user-login", method = RequestMethod.POST)
	public String userLogin( @RequestParam("username") String username, @RequestParam("password") String pass,Model model) {
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from users where username = '"+username+"' and password = '"+ pass+"' ;");
			if(rst.next()) {
				usernameforclass = rst.getString(2);
				return "redirect:/";
				}
			else {
				model.addAttribute("message", "Invalid Username or Password");
				return "home/userLogin";
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "home/userLogin";
		
	}

	@PostMapping("/register/add")
	public String newUseRegister(@ModelAttribute("user") User user)
	{
		try
		{
			userService.saveUser(user);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/";
	}

}
