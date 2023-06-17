package com.home_project.oop_project.controllers.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home_project.oop_project.service.OrderService;
import com.home_project.oop_project.service.ShipperService;
import com.home_project.oop_project.service.UserService;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class ReportController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ShipperService shipperService;
	@Autowired
	private UserService userService;

	@GetMapping("thong-ke")
	public String adminThongKe(Model model) {
		model.addAttribute("totalShipper", shipperService.getTotalItems(null));
		model.addAttribute("totalOrder", orderService.getTotalItems(null));
		model.addAttribute("totalUser", userService.getTotalItems(null));
		model.addAttribute("orderStatusCount", orderService.getReportByStatus());
		model.addAttribute("orderShipperCount", orderService.getReportByShipper());
		model.addAttribute("orderUserCount", orderService.getReportByValue());

		return "admin/adminThongKe";
	}

	@GetMapping("bao-cao")
	public String adminBaoCao(Model model, @Param("month") String month, @Param("year") String year) {
		String startDate, endDate;
		if (month == null && year == null) {
			month = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1);
			year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		}

		startDate = year + "-" + month + "-1";
		endDate = year + "-" + month + "-31";
		model.addAttribute("month", month);
		model.addAttribute("year", year);
		model.addAttribute("currentYear", Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		model.addAttribute("orderStatusCount", orderService.getReportByStatusInMonth(startDate, endDate));
		model.addAttribute("orderByMonth", orderService.getReportInMonth(startDate, endDate));
		model.addAttribute("totalShipper", shipperService.getTotalItems(null));
		model.addAttribute("totalOrderInMonth", orderService.getReportCountInMonth(startDate, endDate));
		model.addAttribute("totalUser", userService.getTotalItems(null));
		return "admin/adminBaoCao";
	}
}
