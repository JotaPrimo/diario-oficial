package com.jotasantos.app.diariooficial.exceptions;

public class CnpjAlreadyExistsException extends RuntimeException{
    public CnpjAlreadyExistsException(String message) {
        super(message);
    }
}
