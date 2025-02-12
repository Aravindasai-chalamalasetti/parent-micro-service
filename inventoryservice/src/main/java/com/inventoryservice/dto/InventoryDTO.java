package com.inventoryservice.dto;

import org.springframework.stereotype.Component;


@Component
public class InventoryDTO {
	private Long inventoryId;
	private String inventoryCode;
	private Integer inventoryQuantity;

	public InventoryDTO(InventoryDTOBuilder inventoryDTOBuilder) {
		this.inventoryId = inventoryDTOBuilder.inventoryId;
		this.inventoryCode = inventoryDTOBuilder.inventoryCode;
		this.inventoryQuantity = inventoryDTOBuilder.inventoryQuantity;
	}

	public InventoryDTO(){

	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public Integer getInventoryQuantity() {
		return inventoryQuantity;
	}

	public static class InventoryDTOBuilder{
		private Long inventoryId;
		private String inventoryCode;
		private Integer inventoryQuantity;

		public InventoryDTOBuilder(){

		}

		public InventoryDTOBuilder setInventoryId(Long inventoryId) {
			this.inventoryId = inventoryId;
			return this;
		}

		public InventoryDTOBuilder setInventoryCode(String inventoryCode) {
			this.inventoryCode = inventoryCode;
			return this;
		}

		public InventoryDTOBuilder setInventoryQuantity(Integer inventoryQuantity) {
			this.inventoryQuantity = inventoryQuantity;
			return this;
		}

		public InventoryDTO build(){
			return new InventoryDTO(this);
		}
	}
}
