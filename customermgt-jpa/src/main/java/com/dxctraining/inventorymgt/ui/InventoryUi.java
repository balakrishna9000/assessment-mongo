package com.dxctraining.inventorymgt.ui;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dxctraining.inventorymgt.customermgt.entities.Customer;
import com.dxctraining.inventorymgt.customermgt.exceptions.CustomerNotFoundException;
import com.dxctraining.inventorymgt.customermgt.service.ICustomerService;
import com.dxctraining.inventorymgt.customermgt.exceptions.InvalidArgumentException;

@Component
public class InventoryUi {
		
		@Autowired
		private ICustomerService customerService;
		
	
	@PostConstruct
	public void runUi() {
		try {
			Customer customer1 = new Customer("balu");
			customerService.add(customer1);
			Customer customer2 = new Customer("krishna");
			customerService.add(customer2);
			Customer customer3 = new Customer("raju");
			customerService.add(customer3);
			
			System.out.println("*****Deleting a customer*****");
			int id3 = customer3.getId();
			customerService.remove(id3);
			System.out.println("removed id"+id3);
			
			System.out.println("*****Fetching customer by id*****");
			int id1 = customer1.getId();
			Customer fetched = customerService.findById(id1);
			System.out.println("fetched id is "+fetched.getId()+" fetched customer = "+fetched.getName());
				
		}catch (InvalidArgumentException e) {
			e.printStackTrace();
		}catch (CustomerNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}