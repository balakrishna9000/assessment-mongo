package com.dxctraining.inventorymgt.customermgt.service;

import java.util.List;

import com.dxctraining.inventorymgt.customermgt.entities.Customer;

public interface ICustomerService {
	Customer add(Customer String);

	void remove(int id);

	Customer findById(int id);

	List<Customer> displayAllCustomers();

	

}
