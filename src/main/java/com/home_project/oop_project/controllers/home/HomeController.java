package com.home_project.oop_project.controllers.home;

import java.util.List;

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
	
	private User usernameValidated;
	public User getUserDetail() {
		return usernameValidated;
	}

	@GetMapping(value = {"about"})
	public String about(Model model) {
		return "home/about";
	}
	
	@GetMapping("login")
	public String userLogin(Model model) {
		return "home/userLogin";
	}
	@GetMapping("/")
	public String Home(Model model) {
		if(usernameValidated!=null){
			model.addAttribute("usernameValidated", usernameValidated);
			return "home/home";		
		}
		else
			return "redirect:/login";
			
	}

	@GetMapping("/register")
	public String registerUser(Model model)
	{
		List<User> listUsers = userService.getAllUsers();
		model.addAttribute("listUsers", listUsers);
		return "home/homeRegister";
	}
	@GetMapping("user-login")
	public String userLog(Model model) {
		
		return "home/userLogin";  
	}
	@RequestMapping(value = "user-login", method = RequestMethod.POST)
	public String userLogin( @RequestParam("username") String username, @RequestParam("password") String pass,Model model) {
		
		try
		{
			// Class.forName("com.mysql.jdbc.Driver");
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root","");
			// Statement stmt = con.createStatement();
			// ResultSet rst = stmt.executeQuery("select * from users where username = '"+username+"' and password = '"+ pass+"' ;");
			// System.out.println(username);
			// System.out.println(pass);
			User user1 = userService.validationUser(username, pass);
			// System.out.println(user1);
			if(user1 == null) {
				model.addAttribute("message", "Tên đăng nhập hoặc mật khẩu không hợp lệ");
				return "home/userLogin";
				
				}
			else {
				usernameValidated = user1;
				return "redirect:/";
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "home/userLogin";
		
	}

	@PostMapping("/register/add")
	public String newUseRegister(@ModelAttribute("user") User user, Model model)
	{
		try
		{
			if (userService.findUserByUsername(user.getUserName()) == null) userService.saveUser(user);
			else {
				List<User> listUsers = userService.getAllUsers();
				model.addAttribute("listUsers", listUsers);
				model.addAttribute("message", "Tên đăng nhập đã tồn tại");
				return "home/homeRegister";
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception:"+e);
		}
		return "redirect:/";
	}

}
