package com.microservice.inventory;

import com.microservice.inventory.entity.Inventory;
import com.microservice.inventory.repository.InventoryRepository;
import com.microservice.inventory.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class InventoryServiceApplicationTests {
	@Autowired
	private InventoryService inventoryService;

	@MockBean
	private InventoryRepository inventoryRepository;

	@Test
	public void addInventoryTest() {
		Inventory inventory=new Inventory(1,"room inventory","towels",100);
		inventoryService.addInventory(inventory);
		verify(inventoryRepository,times(1)).save(inventory);
	}

	@Test
	public void getAllInventoryTest() {
		when(inventoryRepository.findAll()).thenReturn(Stream
				.of(new Inventory(1,"room inventory","towels",100),
						new Inventory(2,"room inventory","shampoo",100))
				.collect(Collectors.toList()));
		assertEquals(2,inventoryService.getAllInventory().size());
	}
	@Test
	public void updateInventoryTest() {
		int invId=1;
		Inventory inventory=new Inventory(1,"room inventory","towels",90);
		inventoryService.updateInventory(invId, inventory);
		verify(inventoryRepository,times(1)).save(inventory);
	}

	@Test
	public void deleteInventoryTest() {
		int invId=1;
		inventoryService.deleteInvenotry(invId);
		verify(inventoryRepository,times(1)).deleteById(invId);
	}

}
