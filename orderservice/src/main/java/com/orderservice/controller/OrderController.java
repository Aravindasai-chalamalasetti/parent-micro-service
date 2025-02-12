package com.orderservice.controller;

import com.orderservice.dto.GeneralHttpResponseDTO;
import com.orderservice.dto.OrderDTO;
import com.orderservice.orderservice.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/addProduct")
	public GeneralHttpResponseDTO<OrderDTO> addProduct(@RequestBody OrderDTO dto) {
		return orderService.addProduct(dto);
	}
	
	@GetMapping("/fetchAllOrdersList")
	public GeneralHttpResponseDTO<List<OrderDTO>> fetchAllOrders(){
		return orderService.fetchOrderList();
	}

}
