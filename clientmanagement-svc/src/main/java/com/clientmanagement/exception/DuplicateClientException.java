package com.clientmanagement.exception;

public class DuplicateClientException extends RuntimeException{

    public DuplicateClientException(String message) {
        super(message);
    }

    public DuplicateClientException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
