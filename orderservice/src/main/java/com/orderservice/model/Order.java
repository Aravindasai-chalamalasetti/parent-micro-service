package com.orderservice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="ordertable")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderLineItems> orderItems;

	public Order(Long orderId, String orderNumber, List<OrderLineItems> orderItems) {
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.orderItems = orderItems;
	}
	public Order(){

	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderLineItems> orderItems) {
		this.orderItems = orderItems;
	}
}
