package com.clientmanagement.util;

import com.clientmanagement.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ClientUtil {

    public static <T> ResponseEntity<ApiResponse<T>> successObject(String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setApiStatus("SUCCESS");
        response.setApiVersion("1.0");
        response.setMessage(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> successObject(String message, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setApiStatus("SUCCESS");
        response.setApiVersion("1.0");
        response.setMessage(message);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> errorObject(String message, HttpStatus errorCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setApiStatus("FAILURE");
        response.setApiVersion("1.0");
        response.setErrorCode(errorCode.name());
        response.setMessage(message);
        return new ResponseEntity<>(response, errorCode);
    }

    public static <T> ResponseEntity<ApiResponse<T>> errorObject(String message, String errorCode, HttpStatus httpStatus) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setApiStatus("FAILURE");
        response.setApiVersion("1.0");
        response.setErrorCode(errorCode);
        response.setMessage(message);
        return new ResponseEntity<>(response, httpStatus);
    }
}
