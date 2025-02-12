package com.orderservice.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Order;

@Repository
public interface OrderDatabase extends JpaRepository<Order, Long>{

}
