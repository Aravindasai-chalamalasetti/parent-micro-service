package com.microservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.ProductDTO;
import com.microservice.model.Product;
import com.microservice.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

	private final ProductService productService;

    @PostMapping("/addProduct")
	@ResponseStatus(HttpStatus.CREATED)
	public Product addProduct(@Valid @RequestBody ProductDTO product) {
		return productService.addProduct(product);
	}
	
	@GetMapping("/fetchProductsList")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public List<ProductDTO> fetchAllProducts(){
		return productService.fetchProductList();
	}



}
