package com.microservice.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.model.Product;

@Repository
public interface ProductDatabase extends MongoRepository<Product,String>{

}
