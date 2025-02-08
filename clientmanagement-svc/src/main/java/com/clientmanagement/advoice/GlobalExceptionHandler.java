package com.clientmanagement.advoice;

import com.clientmanagement.exception.ClientNotFoundException;
import com.clientmanagement.exception.DuplicateClientException;
import com.clientmanagement.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.clientmanagement.util.ClientUtil.errorObject;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateClientException.class)
    public ResponseEntity<ApiResponse<Object>> handlerDuplicateClientException(DuplicateClientException exception) {
        return errorObject(exception.getMessage(), "DUPLICATE_ENTRY", HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleTechnicalException(Exception exception) {
        return  errorObject(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        FieldError fieldError = exception.getBindingResult().getFieldErrors().get(0);
        return errorObject(exception.getMessage(), "MISSING_PARAMETER", HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleClientNotFoundException(ClientNotFoundException exception) {
        return errorObject(exception.getMessage(), "CLIENT_NOT_FOUND", HttpStatus.BAD_REQUEST);
    }

}
