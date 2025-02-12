package com.orderservice.orderservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderservice.database.OrderDatabase;
import com.orderservice.dto.GeneralHttpResponseDTO;
import com.orderservice.dto.InventoryDTO;
import com.orderservice.dto.OrderDTO;
import com.orderservice.model.Order;
import com.orderservice.model.OrderLineItems;
import com.orderservice.serviceDTO.OrderDtoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderService {

	public OrderService(OrderDatabase repo, OrderDtoService dtoService, WebClient.Builder webClientBuilder){
        this.repo = repo;
        this.dtoService = dtoService;
        this.webClientBuilder = webClientBuilder;
    }
	private final OrderDatabase repo;

	private final OrderDtoService dtoService;

	private final WebClient.Builder webClientBuilder;

	public GeneralHttpResponseDTO<OrderDTO> addProduct(OrderDTO dto)  {
		GeneralHttpResponseDTO<OrderDTO> ord = new GeneralHttpResponseDTO<>();
		try {

			Order order = dtoService.convertDtoToOrder(dto);
			List<OrderLineItems> orderItems = order.getOrderItems();
			if (orderItems == null || orderItems.isEmpty()) {
				throw new RuntimeException("Order items not found");
			}
			if (!orderItems.isEmpty()) {
				List<String> orderItem = order.getOrderItems().stream().map(OrderLineItems::getItemCode).toList();
				String invData = webClientBuilder.build().get().uri("http://inventory-service/inventory/fetchInStockDetails",
								uriBuilder -> uriBuilder.queryParam("skucode", orderItem.toArray()).build())
						.retrieve()
						.bodyToMono(String.class)
						.block();
				ObjectMapper objectMapper = new ObjectMapper();
				InventoryDTO[] invv = objectMapper.readValue(invData, InventoryDTO[].class);
//			String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/inventory/fetchInStockDetails")
//					.queryParam("sku-code", orderItem)
//					.toUriString();
//			OrderInventoryResponseDTO[] invData = webClient.get().uri(url)
//					.retrieve()
//					.bodyToMono(OrderInventoryResponseDTO[].class)
//					.block();
				boolean b = Arrays.stream(invv).allMatch(InventoryDTO::isInStock);
				if (b) {
					Order newOrder = repo.save(order);
					ord.setDate(new Date());
					ord.setResponseCode(201);
					ord.setResponseBody(dtoService.mapOrderToDtoList(newOrder));
					ord.setStatus(HttpStatus.CREATED);
				} else {
					ord.setDate(new Date());
					ord.setResponseMessage("Order is not available");
					ord.setStatus(HttpStatus.NOT_FOUND);
				}
			} else {
				ord.setDate(new Date());
				ord.setResponseMessage("No order items found");
				ord.setStatus(HttpStatus.NOT_FOUND);
			}
		}catch (JsonProcessingException e){
			e.printStackTrace();
		}
		return ord;
	}

	public GeneralHttpResponseDTO<List<OrderDTO>> fetchOrderList(){
		GeneralHttpResponseDTO<List<OrderDTO>> ord = new GeneralHttpResponseDTO<>();
		List<Order> orderList = repo.findAll();
		if(orderList != null && !orderList.isEmpty()){
			ord.setDate(new Date());
			ord.setResponseCode(201);
			ord.setResponseBody(dtoService.convertOrderToDtoList(orderList));
			ord.setStatus(HttpStatus.ACCEPTED);
		}else{
			ord.setDate(new Date());
			ord.setResponseCode(401);
			ord.setResponseMessage("Order list is empty");
			ord.setStatus(HttpStatus.BAD_REQUEST);
		}
		return ord;
	}
}
