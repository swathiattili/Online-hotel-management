package com.code.userservice.service;

import com.code.userservice.entity.Inventory;
import com.code.userservice.repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public void addInventory(Inventory inv) {
		inventoryRepository.save(inv);	
	}


	public List<Inventory> getAllInventory() {
		return inventoryRepository.findAll();	 
	}


	public Optional<Inventory> getInventoryById(int invId) {
		return inventoryRepository.findById(invId);
	}


	public void updateInventory(int invId, Inventory inv) {
		inventoryRepository.save(inv);
	}


	public void deleteInvenotry(int invId) {
		inventoryRepository.deleteById(invId);
	}

}
