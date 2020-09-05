package com.dxctraining.inventorymgt.customermgt.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String msg){
        super(msg);
    }

}