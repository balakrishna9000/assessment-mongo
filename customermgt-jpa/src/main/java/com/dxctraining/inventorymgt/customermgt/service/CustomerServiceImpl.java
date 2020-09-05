package com.dxctraining.inventorymgt.customermgt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.inventorymgt.customermgt.entities.Customer;
import com.dxctraining.inventorymgt.customermgt.dao.ICustomerDao;
import com.dxctraining.inventorymgt.customermgt.exceptions.*;
@Transactional
@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao dao;

    private void validate(Customer String) {
        if(String==null)
        {
            throw new InvalidArgumentException("supplier cant be null");
        }
    }

    @Override
    public Customer add(Customer String) {
    validate(String);
      dao.add(String);
      return String;
    }
  
    @Override
    public void remove(int id) {
  	     validateId(id);
  	     dao.deleteById(id);
  	    }

  	private void validateId(int id) {
  	    if(id<0)
  	        {
  	            throw new InvalidArgumentException("id cant be -ve");

  	        }
  	}

    @Override
    public Customer findById(int id) {
        Optional<Customer> optional=dao.findById(id);
       if(!optional.isPresent())
       {
             throw new CustomerNotFoundException("supplier not found="+id);
       }
       Customer customer= optional.get();
        return customer;
     }

	@Override
	public List<Customer> displayAllCustomers() {
		 List<Customer>list=dao.displayAllCustomers();
	        return list;	
	        }
}