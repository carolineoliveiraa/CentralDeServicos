package com.jessicaoliveira.CentralDeServicos.services.exceptions;

public class DataIntegratyViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegratyViolationException(String message) {
        super(message);
    }

    public DataIntegratyViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegratyViolationException(Throwable cause) {
        super(cause);
    }
}

