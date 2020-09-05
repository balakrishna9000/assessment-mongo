package com.dxctraining.mongoexperiments.productsmgt.service;

import com.dxctraining.mongoexperiments.productsmgt.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private MongoTemplate mongo;

    @Override
    public Product save(Product product) {
        System.out.println("using mongotemplate save");
        product = mongo.save(product);
        return product;
    }

    @Override
    public Product findById(String id) {
        Product product = mongo.findById(id,Product.class);
        return product;
    }

    @Override
    public void removeById(String id) {
        Product product=findById(id);
        mongo.remove(product);
        /*
        Criteria criteria=Criteria.where("id").is(id);
        Query query=Query.query(criteria);
        mongo.findAndRemove(query,Employee.class);
       */
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> list = mongo.findAll(Product.class);
        return list;
    }

    @Override
    public List<Product> findByName(String name) {
        Criteria criteria=Criteria.where("name").is(name) ;
        Query query = Query.query(criteria);
        List<Product> list = mongo.find(query, Product.class);
        return list;
    }
}
