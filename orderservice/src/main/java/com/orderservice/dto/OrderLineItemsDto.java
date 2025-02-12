package com.orderservice.dto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderLineItemsDto {
	private Long itemId;
	private String itemCode;
	private BigDecimal itemPrice;
	private int itemQuantity;

	public OrderLineItemsDto(OrderLineItemsDtoBuilder orderLineItemsBuilder) {
		this.itemId = orderLineItemsBuilder.itemId;
		this.itemCode = orderLineItemsBuilder.itemCode;
		this.itemPrice = orderLineItemsBuilder.itemPrice;
		this.itemQuantity = orderLineItemsBuilder.itemQuantity;
	}

	public OrderLineItemsDto() {}

	public Long getItemId() {
		return itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	@Override
	public String toString() {
		return "OrderLineItemsDto{" +
				"itemId=" + itemId +
				", itemCode='" + itemCode + '\'' +
				", itemPrice=" + itemPrice +
				", itemQuantity=" + itemQuantity +
				'}';
	}

	public static class OrderLineItemsDtoBuilder {
		private Long itemId;
		private String itemCode;
		private BigDecimal itemPrice;
		private int itemQuantity;

		public OrderLineItemsDtoBuilder() {}

		public OrderLineItemsDtoBuilder setItemId(Long itemId) {
			this.itemId = itemId;
			return this;
		}

		public OrderLineItemsDtoBuilder setItemCode(String itemCode) {
			this.itemCode = itemCode;
			return this;
		}

		public OrderLineItemsDtoBuilder setItemPrice(BigDecimal itemPrice) {
			this.itemPrice = itemPrice;
			return this;
		}

		public OrderLineItemsDtoBuilder setItemQuantity(int itemQuantity) {
			this.itemQuantity = itemQuantity;
			return this;
		}

		public OrderLineItemsDto build() {
			return new OrderLineItemsDto(this);
		}
	}
}