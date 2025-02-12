package com.microservice.serviceDTO;

import com.microservice.dto.ProductDTO;
import com.microservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceDTO {
	public Product convertDtoToProduct(ProductDTO productDetails) {
		Product prod = new Product();
		prod.setProductId(productDetails.getProductId());
		prod.setProductName(productDetails.getProductName());
		prod.setProcessor(productDetails.getProcessor());
		prod.setPrice(productDetails.getPrice());

		return prod;
	}

	public ProductDTO convertProductToDto(Product prod) {
		ProductDTO product = new ProductDTO.ProductDTOBuilder()
				.setProductId(prod.getProductId())
				.setProductName(prod.getProductName())
				.setProcessor(prod.getProcessor())
				.setPrice(prod.getPrice())
				.build();
		return product;
	}

	public List<ProductDTO> getProductToDtoList(List<Product> prod){
		List<ProductDTO> dtoList = prod.stream().map(p->mapProductToDto(p)).collect(Collectors.toList());
		return dtoList;
	}

	private ProductDTO mapProductToDto(Product prod) {
		ProductDTO dto = convertProductToDto(prod);
		return dto;
	}
}
