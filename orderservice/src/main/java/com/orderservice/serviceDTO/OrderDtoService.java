package com.orderservice.serviceDTO;

import com.orderservice.dto.OrderDTO;
import com.orderservice.dto.OrderLineItemsDto;
import com.orderservice.model.Order;
import com.orderservice.model.OrderLineItems;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDtoService {

	public Order convertDtoToOrder(OrderDTO dto) {
		Order order =  new Order();
		List<OrderLineItems> item = dto.getLineItem().stream().map(r->mapOrderToDto(r)).collect(Collectors.toList());
		order.setOrderItems(item);
		order.setOrderNumber(UUID.randomUUID().toString());
		return order;
	}
	
	private OrderLineItems mapOrderToDto(OrderLineItemsDto dto) {
		OrderLineItems order = new OrderLineItems();
		order.setItemCode(dto.getItemCode());
		order.setItemId(dto.getItemId());
		order.setItemPrice(dto.getItemPrice());
		order.setItemQuantity(dto.getItemQuantity());
		return order;
	}
	
	public List<OrderDTO> convertOrderToDtoList(List<Order> order){
		List<OrderDTO> dto = order.stream().map(r->mapOrderToDtoList(r)).collect(Collectors.toList());
		return dto;
	}
	
	public OrderDTO mapOrderToDtoList(Order order){
		OrderDTO dto = new OrderDTO();
				dto.setOrderId(order.getOrderId());
				dto.setOrderNumber(order.getOrderNumber());
				dto.setLineItem(convertOrderItemsToDtoList(order.getOrderItems()));
		return dto;
				
	}
	
	public List<OrderLineItemsDto> convertOrderItemsToDtoList(List<OrderLineItems> order){
		List<OrderLineItemsDto> items = order.stream().map(r->mapLineItemsToItemsDto(r)).collect(Collectors.toList());
		return items;
	}
	
	private OrderLineItemsDto mapLineItemsToItemsDto(OrderLineItems dto) {
		OrderLineItemsDto order = new OrderLineItemsDto.OrderLineItemsDtoBuilder()
				.setItemId(dto.getItemId())
				.setItemCode(dto.getItemCode())
				.setItemPrice(dto.getItemPrice())
				.setItemQuantity(dto.getItemQuantity())
				.build();
		return order;
	}


}
