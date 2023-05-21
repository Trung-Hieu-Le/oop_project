package com.home_project.oop_project.controllers;

import java.sql.*;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
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

}
