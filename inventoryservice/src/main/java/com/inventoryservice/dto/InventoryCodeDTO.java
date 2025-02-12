package com.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class InventoryCodeDTO {

    private String inventoryCode;
    private boolean isInStock;

    public InventoryCodeDTO(InventoryCodeDTOBuilder inv) {
        this.inventoryCode = inv.inventoryCode;
        this.isInStock = inv.isInStock;
    }

    public InventoryCodeDTO(){}
    @JsonProperty("inventoryCode")
    public String getInventoryCode() {
        return inventoryCode;
    }
    @JsonProperty("isInStock")
    public boolean isInStock() {
        return isInStock;
    }

    public static class InventoryCodeDTOBuilder{
        private String inventoryCode;
        private boolean isInStock;

        public InventoryCodeDTOBuilder(){}
        public InventoryCodeDTOBuilder setInventoryCode(String inventoryCode) {
            this.inventoryCode = inventoryCode;
            return this;
        }

        public InventoryCodeDTOBuilder setInStock(boolean inStock) {
            this.isInStock = inStock;
            return this;
        }

        public InventoryCodeDTO build(){
            return new InventoryCodeDTO(this);
        }
    }
}
