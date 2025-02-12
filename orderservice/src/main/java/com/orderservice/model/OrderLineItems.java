package com.orderservice.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="order-line-items")
public class OrderLineItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	private String itemCode;
	private BigDecimal itemPrice;
	private int itemQuantity;

	public OrderLineItems(Long itemId, String itemCode, BigDecimal itemPrice, int itemQuantity) {
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public OrderLineItems(){

	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

}
