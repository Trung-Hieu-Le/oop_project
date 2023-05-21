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

import com.home_project.oop_project.entity.User;
import com.home_project.oop_project.service.UserService;

@Controller
@RequestMapping("/admin/user")

public class UserController {

	private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    // handler method to handle list Users and return mode and view
    @GetMapping("/{pageNo}")
    public String listUsers(Model model, @Param("keyword") String keyword, @PathVariable int pageNo) {
        pageNo--;
		int pageSize=10;
		int totalItems= userService.getAllUsers(keyword, 0,9999).size();
        int totalPages;
        if (totalItems!=0){
			if(totalItems%pageSize==0) {totalPages= totalItems / pageSize;}
			else {totalPages= totalItems / pageSize + 1;}
		}
		else {totalPages=1;}
		List<User> listUsers = userService.getAllUsers(keyword, pageNo, pageSize);
		listUsers.size();
		model.addAttribute("users", listUsers);
        model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", pageNo+1);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("totalItems", totalItems);
        return "admin/adminUser"; 
    }

    @GetMapping("/new")
    public String createUserForm(Model model) {

        // create User object to hold User form data
        User user = new User();
        model.addAttribute("user", user);
        return "admin/addUser";

    }

    @PostMapping("/add")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/user/1";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/editUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable Long id,
                              @ModelAttribute("user") User user,
                              Model model) {

        // get User from database by id
        User existingUser = userService.getUserById(id);
        existingUser.setId(id);
        existingUser.setName(user.getName());
        existingUser.setPassword(user.getPassword());
        existingUser.setDiaChi(user.getDiaChi());
        existingUser.setEmail(user.getEmail());
        existingUser.setSdt(user.getSdt());
        // save updated User object
        userService.updateUser(existingUser);
        return "redirect:/admin/user/1";
    }

    // handler method to handle delete User request

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/admin/user/1";
    }
}
