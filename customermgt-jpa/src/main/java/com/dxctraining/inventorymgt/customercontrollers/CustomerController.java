package com.dxctraining.inventorymgt.customercontrollers;

import com.dxctraining.inventorymgt.customermgt.entities.Customer;
import com.dxctraining.inventorymgt.customermgt.service.ICustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.*;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private Session sessionData;


    @PostConstruct
    public void init(){
    	Customer customer1=new Customer("balu");
    	customerService.add(customer1);

    	Customer customer2=new Customer("krishna");
    	customerService.add(customer1);
    }


    /**
     *
     *  http://localhost:8585/profile?id=2
     */
    @GetMapping("/profile")
    public ModelAndView customerDetails(@RequestParam("id")int id){
       Customer cus=customerService.findById(id);
       ModelAndView modelAndView=new ModelAndView("details","customer",cus);
       return modelAndView;
    }

    /**
     *  http://localhost:8585/listall
     */
    @GetMapping("/listall")
    public ModelAndView all(){
        List<Customer>values=customerService.displayAllCustomers();
        ModelAndView modelAndView=new ModelAndView("list","customer",values);
        return modelAndView;
    }
}