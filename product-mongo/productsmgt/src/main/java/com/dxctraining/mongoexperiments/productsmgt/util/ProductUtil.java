package com.dxctraining.mongoexperiments.productsmgt.util;

import com.dxctraining.mongoexperiments.productsmgt.dto.ProductDto;
import com.dxctraining.mongoexperiments.productsmgt.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public ProductDto productDto(Product product){
    	ProductDto dto=new ProductDto(product.getId(),product.getName());
        return dto;
    }

}
