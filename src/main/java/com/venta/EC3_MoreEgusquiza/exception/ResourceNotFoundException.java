package com.venta.EC3_MoreEgusquiza.exception;

public class ResourceNotFoundException
        extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }
}
