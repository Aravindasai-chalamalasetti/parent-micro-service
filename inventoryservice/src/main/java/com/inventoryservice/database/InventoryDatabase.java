package com.inventoryservice.database;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryservice.model.Inventory;

@Repository
public interface InventoryDatabase extends JpaRepository<Inventory, Long>{
	Optional<Inventory> findByInventoryCode(String inventoryCode);

	List<Inventory> findByInventoryCodeIn(List<String> inventoryCode);
}
