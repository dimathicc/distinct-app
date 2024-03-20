package com.dimathicc.distinct.exception;

import com.dimathicc.distinct.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            EmptyRequestException.class,
            NumbersSizeException.class
    })
    public ResponseEntity<ErrorResponse> handleBadRequestException(Exception e) {
        return defaultErrorResponse(e, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponse> defaultErrorResponse(Exception e, HttpStatus status) {
        ErrorResponse response = new ErrorResponse(status.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, status);
    }
}
