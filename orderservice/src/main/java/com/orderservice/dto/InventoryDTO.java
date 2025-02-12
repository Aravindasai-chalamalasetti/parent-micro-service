package com.orderservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class InventoryDTO {
    @JsonProperty("inventoryCode")
    private String inventoryCode;
    @JsonProperty("isInStock")
    private boolean inStock;

    public InventoryDTO(InventoryCodeDTOBuilder inv) {
        this.inventoryCode = inv.inventoryCode;
        this.inStock = inv.inStock;
    }

    public InventoryDTO(){}

    public String getInventoryCode() {
        return inventoryCode;
    }

    public boolean isInStock() {
        return inStock;
    }

    public static class InventoryCodeDTOBuilder{
        private String inventoryCode;
        private boolean inStock;

        public InventoryCodeDTOBuilder(){}
        public InventoryCodeDTOBuilder setInventoryCode(String inventoryCode) {
            this.inventoryCode = inventoryCode;
            return this;
        }

        public InventoryCodeDTOBuilder setInStock(boolean inStock) {
            this.inStock = inStock;
            return this;
        }

        public InventoryDTO build(){
            return new InventoryDTO(this);
        }
    }
}
