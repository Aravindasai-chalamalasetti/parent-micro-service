package com.microservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDTO {
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

	public ProductDTO(ProductDTOBuilder productDTOBuilder) {
		this.productId = productDTOBuilder.productId;
		this.productName = productDTOBuilder.productName;
		this.processor = productDTOBuilder.processor;
		this.price = productDTOBuilder.price;
	}

	public ProductDTO() {

	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProcessor() {
		return processor;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public static class ProductDTOBuilder{
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

		public ProductDTOBuilder(){

		}

		public ProductDTOBuilder setProductId(String productId) {
			this.productId = productId;
			return this;
		}

		public ProductDTOBuilder setProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public ProductDTOBuilder setProcessor(String processor) {
			this.processor = processor;
			return this;
		}

		public ProductDTOBuilder setPrice(BigDecimal price) {
			this.price = price;
			return this;
		}

		public ProductDTO build(){
			return new ProductDTO(this);
		}
	}
}
