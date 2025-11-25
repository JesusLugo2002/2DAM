package com.docencia.rest.exceptions;

public class ResourceNotFoundException extends Exception {


    public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable exception) {
        super(message, exception);
    }    

}
