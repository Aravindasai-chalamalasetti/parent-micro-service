package com.orderservice.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.OrderLineItems;

@Repository
public interface OrderLineItemsDatabase extends JpaRepository<OrderLineItems, Long>{

}
