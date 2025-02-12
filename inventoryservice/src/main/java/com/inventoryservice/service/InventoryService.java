package com.inventoryservice.service;

import com.inventoryservice.database.InventoryDatabase;
import com.inventoryservice.dto.InventoryCodeDTO;
import com.inventoryservice.dto.InventoryDTO;
import com.inventoryservice.model.Inventory;
import com.inventoryservice.serviceDTO.InventoryServiceDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

	public InventoryService(InventoryDatabase repo, InventoryServiceDto mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}

	private final InventoryDatabase repo;

	private final InventoryServiceDto mapper;

	public InventoryDTO addInventory(InventoryDTO inv) {
		Inventory inventory = mapper.convertDtoToInvntory(inv);
		Inventory saveInventory = repo.save(inventory);
		return mapper.convertInventoryToDto(saveInventory);
	}

	public List<InventoryDTO> fetchInventoriesList(){
		List<Inventory> invList = repo.findAll();
		return mapper.convertInventoryToDtoList(invList);
	}

	@Transactional(readOnly = true)
	public List<InventoryCodeDTO> inInStock(List<String> invCode) {
		List<Inventory> invList = repo.findByInventoryCodeIn(invCode);
		List<InventoryCodeDTO> inv = mapper.convertInventoryToDTO(invList);
		System.out.println("inv--service--output--- "+ inv);
		return invList.stream().map(invv -> new InventoryCodeDTO.InventoryCodeDTOBuilder()
				.setInventoryCode(invv.getInventoryCode())
				.setInStock(invv.getInventoryQuantity() > 0)
				.build()).collect(Collectors.toList());

	}
}
