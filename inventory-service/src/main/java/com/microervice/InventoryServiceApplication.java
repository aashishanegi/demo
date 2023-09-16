package com.microervice;

import com.microervice.model.Inventory;
import com.microervice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"microervice.*"})
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {
			Inventory inventory= new Inventory();
			inventory.setSkuCode("Iphone");
			inventory.setQuantity(0);

			Inventory inventory1= new Inventory();
			inventory1.setSkuCode("OnePlus");
			inventory1.setQuantity(50);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
}
}
