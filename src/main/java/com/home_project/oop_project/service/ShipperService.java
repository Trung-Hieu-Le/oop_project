package com.home_project.oop_project.service;

import java.util.List;

import com.home_project.oop_project.entity.Shipper;

public interface ShipperService {
    List<Shipper> getAllShippers(String keyword, int pageNo, int pageSize);
	
	Shipper saveShipper(Shipper shipper);
	
	Shipper getShipperById(Long id);
	
	Shipper updateShipper(Shipper shipper);
	
	void deleteShipperById(Long id);
}
