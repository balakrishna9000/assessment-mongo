package com.dxctraining.mongoexperiments.productsmgt.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg){
        super(msg);
    }

}
