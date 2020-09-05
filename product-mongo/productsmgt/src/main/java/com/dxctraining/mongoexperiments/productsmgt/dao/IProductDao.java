package com.dxctraining.mongoexperiments.productsmgt.dao;


import com.dxctraining.mongoexperiments.productsmgt.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IProductDao extends MongoRepository<Product, String> {

    List<Product> findByName(String firstName);

}
