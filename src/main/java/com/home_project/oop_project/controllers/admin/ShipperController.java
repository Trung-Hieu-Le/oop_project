package com.home_project.oop_project.controllers.admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.home_project.oop_project.entity.Shipper;
import com.home_project.oop_project.service.ShipperService;

@Controller
@RequestMapping("/admin/shipper")
public class ShipperController {
    @Autowired
    private ShipperService shipperService;

    public ShipperController(ShipperService ShipperService) {
        super();
        this.shipperService = ShipperService;
    }

    // handler method to handle list Shippers and return mode and view
    @GetMapping("/{pageNo}")
    public String listShippers(Model model, @Param("keyword") String keyword, @PathVariable int pageNo) {
		int pageSize=10;
        int totalItems= shipperService.getTotalItems(keyword);
        int totalPages;
        if (totalItems!=0){
			if(totalItems%pageSize==0) {totalPages= totalItems / pageSize;}
			else {totalPages= totalItems / pageSize + 1;}
		}
		else {totalPages=1;}
		List<Shipper> listShippers = shipperService.getAllShippers(keyword, pageNo-1, pageSize);
		listShippers.size();
		model.addAttribute("shippers", listShippers);
        model.addAttribute("keyword", keyword);
		model.addAttribute("currentPage", pageNo);
    	model.addAttribute("totalPages", totalPages);
    	model.addAttribute("totalItems", totalItems);        
        return "admin/adminShipper";
    }

    @GetMapping("/new")
    public String createShipperForm(Model model) {

        // create Shipper object to hold Shipper form data
        Shipper shipper = new Shipper();
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("shipper", shipper);
        return "admin/addShipper";

    }

    @PostMapping("/add")
    public String saveShipper(@ModelAttribute("shipper") Shipper shipper) {
        shipperService.saveShipper(shipper);
        return "redirect:/admin/shipper/1";
    }

    @GetMapping("/edit/{id}")
    public String editShipperForm(@PathVariable Long id, Model model) {
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("shipper", shipperService.getShipperById(id));
        return "admin/editShipper";
    }

    @PostMapping("/update/{id}")
    public String updateShipper(@PathVariable Long id,
                              @ModelAttribute("shipper") Shipper shipper,
                              Model model) {

        // get Shipper from database by id
        Shipper existingShipper = shipperService.getShipperById(id);
        existingShipper.setId(id);
        existingShipper.setFullName(shipper.getFullName());
        existingShipper.setNgaySinh(shipper.getNgaySinh());
        existingShipper.setDiaChi(shipper.getDiaChi());
        existingShipper.setEmail(shipper.getEmail());
        existingShipper.setSdt(shipper.getSdt());
        existingShipper.setCccd(shipper.getCccd());
        // save updated Shipper object
        shipperService.updateShipper(existingShipper);
        return "redirect:/admin/shipper/1";
    }

    // handler method to handle delete Shipper request

    @GetMapping("delete/{id}")
    public String deleteShipper(@PathVariable Long id) {
        shipperService.deleteShipperById(id);
        return "redirect:/admin/shipper/1";
    }
}
