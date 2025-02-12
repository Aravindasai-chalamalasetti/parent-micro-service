package com.inventoryservice.model;

import jakarta.persistence.*;

@Entity
@Table(name="inventorytable")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inventoryId;
	private String inventoryCode;
	private Integer inventoryQuantity;

	public Inventory(Long inventoryId, String inventoryCode, Integer inventoryQuantity) {
		this.inventoryId = inventoryId;
		this.inventoryCode = inventoryCode;
		this.inventoryQuantity = inventoryQuantity;
	}
	public Inventory(){

	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	public Integer getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(Integer inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}
}
