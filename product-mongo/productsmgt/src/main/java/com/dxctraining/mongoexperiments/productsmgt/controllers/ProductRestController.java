package com.dxctraining.mongoexperiments.productsmgt.controllers;

import com.dxctraining.mongoexperiments.productsmgt.dto.CreateProductRequest;
import com.dxctraining.mongoexperiments.productsmgt.dto.ProductDto;
import com.dxctraining.mongoexperiments.productsmgt.entities.Product;
import com.dxctraining.mongoexperiments.productsmgt.service.IProductService;
import com.dxctraining.mongoexperiments.productsmgt.util.ProductUtil;

import ch.qos.logback.classic.pattern.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductRestController {

    @Autowired
    private IProductService service;

    @Autowired
    private ProductUtil util;

    /*
      uri is /products/add
      url http://localhost:8585/products/add
   */
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody CreateProductRequest requestData) {
    	Product product=new Product(requestData.getName());
    	product=service.save(product);
    	ProductDto response=util.productDto(product);
        return response;
    }


	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductDto findProductById(@PathVariable("id")String id) {
		Product product = service.findById(id);
		ProductDto response = util.productDto(product);
		return response;
	}
	
	@GetMapping("/get/product/{name}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDto> fetchProductByName(@PathVariable("name")String name){
		List<Product>list = service.findByName(name);
		List<ProductDto> response = new ArrayList<>();
		for(Product product:list) {
			ProductDto productDto = util.productDto(product);
			response.add(productDto);
		}
		return response;
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductDto> fetchAllProducts(){
		List<Product> list = service.findAllProducts();
		List<ProductDto>response = new ArrayList<>();
		for(Product product:list) {
			ProductDto dto = util.productDto(product);
			response.add(dto);
		}
		return response;
	}

}


