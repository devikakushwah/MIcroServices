package com.service.Userservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found");
    }

    public ResourceNotFoundException(String mssg){
        super(mssg);
    }
}
