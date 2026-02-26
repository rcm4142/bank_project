package com.pie.app.exception;

import org.springframework.http.HttpStatus;

public class BankException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public BankException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
    public BankException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
