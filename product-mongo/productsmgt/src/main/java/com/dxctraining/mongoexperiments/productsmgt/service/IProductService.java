package com.dxctraining.mongoexperiments.productsmgt.service;

import com.dxctraining.mongoexperiments.productsmgt.entities.Product;

import java.util.List;

public interface IProductService {

    Product save(Product product);

    Product findById(String id);

    List<Product>findByName(String Name);

    void removeById(String id);

    List<Product> findAllProducts();

}
