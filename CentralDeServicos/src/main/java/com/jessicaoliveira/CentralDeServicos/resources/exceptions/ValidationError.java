package com.jessicaoliveira.CentralDeServicos.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(){
        super();
    }

    public ValidationError(List<FieldMessage> errors) {
        this.errors = errors;
    }

    public ValidationError(Long timestamp, Integer status, String error, List<FieldMessage> errors) {
        super(timestamp, status, error);
        this.errors = errors;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
