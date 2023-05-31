package com.home_project.oop_project.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.home_project.oop_project.entity.Shipper;
import com.home_project.oop_project.repository.ShipperRepository;
import com.home_project.oop_project.service.ShipperService;

@Service
public class ShipperServiceImpl implements ShipperService{
    private ShipperRepository shipperRepository;
	
	public ShipperServiceImpl(ShipperRepository shipperRepository) {
		super();
		this.shipperRepository = shipperRepository;
	}

	@Override
	public List<Shipper> getAllShippers() {
        return shipperRepository.findAll();
	}

	@Override
	public List<Shipper> getAllShippers(String keyword, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
		if (keyword != null) {
            return shipperRepository.search(keyword, pageNo*pageSize, pageSize);
        }
        return shipperRepository.findAll(pageable).get().toList();
	}

	@Override
	public int getTotalItems(String keyword){
		if (keyword !=null){
			return shipperRepository.getTotalItemsSearched(keyword);
		}
		return shipperRepository.getTotalItems();
	}

	@Override
	public Shipper saveShipper(Shipper shipper) {
		return shipperRepository.save(shipper);
	}

	@Override
	public Shipper getShipperById(Long id) {
		return shipperRepository.findById(id).get();
	}

	@Override
	public Shipper updateShipper(Shipper shipper) {
		return shipperRepository.save(shipper);
	}

	@Override
	public void deleteShipperById(Long id) {
		shipperRepository.deleteById(id);	
	}

	
}
