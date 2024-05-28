package com.jotasantos.app.diariooficial.exceptions.handler;

public class CnpjAlreadyExistsException extends RuntimeException{
    public CnpjAlreadyExistsException(String message) {
        super(message);
    }
}
