package com.home_project.oop_project.controllers.home;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.home_project.oop_project.entity.Shipper;
import com.home_project.oop_project.service.ShipperService;

@Controller
public class HomeShipperController {
    @Autowired
	private ShipperService shipperService;

    @GetMapping(value={"join","join/"})
	public String join(Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);
        System.out.println(currentDate);
		return "home/join";
	}

    @PostMapping("/shipper/add")
    public String saveShipper(@ModelAttribute("shipper") Shipper shipper) {
        shipperService.saveShipper(shipper);
        return "redirect:/join";
    }
}
