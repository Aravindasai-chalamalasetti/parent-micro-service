package com.inventoryservice.controller;

import com.inventoryservice.dto.InventoryCodeDTO;
import com.inventoryservice.dto.InventoryDTO;
import com.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

	private final InventoryService inventoryService;

    @PostMapping("/addInventory")
	@ResponseStatus(HttpStatus.CREATED)
	public InventoryDTO addInventoryProduct(@RequestBody InventoryDTO inv) {
		return inventoryService.addInventory(inv);
	}
	
	@GetMapping("/fetchInventoryList")
	public List<InventoryDTO> fetchInventoryList(){
		return inventoryService.fetchInventoriesList();
	}
	
	@GetMapping("/fetchInStockDetails")
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryCodeDTO> isInStock(@RequestParam("skucode") List<String> invCode) {
		System.out.println("Received input sku-code: " + invCode);
		List<InventoryCodeDTO> inv = inventoryService.inInStock(invCode);
		System.out.println("Received output sku-code: " +  inv.get(0).getInventoryCode() + "----" + inv.get(0).isInStock());
		return inv;
	}

}
