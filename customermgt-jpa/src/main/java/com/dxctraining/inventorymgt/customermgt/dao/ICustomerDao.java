package com.dxctraining.inventorymgt.customermgt.dao;

import java.util.List;

import com.dxctraining.inventorymgt.customermgt.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerDao extends JpaRepository<Customer,Integer>{

	void add(Customer string);

	List<Customer> displayAllCustomers();
		
	//List<Customer> findById(int id);
	
	//List<Customer> findByName(String name);
	
}
