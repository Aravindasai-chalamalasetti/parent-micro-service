package com.orderservice.dto;

import org.springframework.stereotype.Component;

import java.util.List;




@Component
public class OrderDTO {
	private Long orderId;
	private String orderNumber;
    private List<OrderLineItemsDto> lineItem;
	public OrderDTO(){}

	public OrderDTO(Long orderId, String orderNumber, List<OrderLineItemsDto> lineItem) {
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.lineItem = lineItem;
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

	public List<OrderLineItemsDto> getLineItem() {
		return lineItem;
	}

	public void setLineItem(List<OrderLineItemsDto> lineItem) {
		this.lineItem = lineItem;
	}
}
