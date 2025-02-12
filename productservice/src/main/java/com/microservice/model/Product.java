package com.microservice.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Document(collection = "product-details")
public class Product {
    @Id
    private String productId;
    @NotEmpty(message = "productName can't be empty")
    @Size(min = 4,message = "use minimum 5 character's for productName")
    @Size(max = 35,message = "productName length not more than 35 character's")
    private String productName;
    @NotNull(message = "processor can't be empty")
    @Size(min = 6,message = "use minimum 5 character's for processor")
    @Size(max = 35,message = "processor length not more than 35 character's")
    private String processor;
    @NotNull(message = "product price can't be empty")
    @Min(value = 4999,message = "Price must be greater than or equal to 4999")
    private BigDecimal price;

    public Product(String productId, String productName, String processor, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.processor = processor;
        this.price = price;
    }
    public Product(){

    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
