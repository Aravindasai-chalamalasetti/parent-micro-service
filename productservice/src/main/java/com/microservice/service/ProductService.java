package com.microservice.service;

import com.microservice.database.ProductDatabase;
import com.microservice.dto.ProductDTO;
import com.microservice.model.Product;
import com.microservice.serviceDTO.ProductServiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductService {

    public ProductService(ProductDatabase repo, ProductServiceDTO mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
   private static final Logger log =  Logger.getLogger(ProductService.class.getName());


	private final ProductDatabase repo;

	private final ProductServiceDTO mapper;

    public Product addProduct(ProductDTO productDetails) {
		Product prod = mapper.convertDtoToProduct(productDetails);
		repo.save(prod);
		log.info("product {} is saved successfully" + prod.getProductId());
		return prod;
	}

	public List<ProductDTO> fetchProductList() {
		// List<ProductDTO> prod = mapper.getProductToDtoList( repo.findAll());
		return mapper.getProductToDtoList(repo.findAll());
	}
}
