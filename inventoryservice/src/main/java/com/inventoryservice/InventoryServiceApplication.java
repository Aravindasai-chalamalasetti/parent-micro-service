package com.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.inventoryservice.database.InventoryDatabase;
import com.inventoryservice.model.Inventory;

@SpringBootApplication(scanBasePackages = "com.inventoryservice")
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InventoryServiceApplication.class);
	}
	
//	@Bean
//	public CommandLineRunner loadData(InventoryDatabase inventoryDatabase) {
//		return args -> {
//			Inventory inv = new Inventory();
//			inv.setInventoryCode("Iphone 15 Pro");
//			inv.setInventoryQuantity(1583);
//			
//			Inventory inv1 = new Inventory();
//			inv1.setInventoryCode("Iphone 11 Pro");
//			inv1.setInventoryQuantity(0);
//			
//			inventoryDatabase.save(inv);
//			inventoryDatabase.save(inv1);
//		};
//	}
}
