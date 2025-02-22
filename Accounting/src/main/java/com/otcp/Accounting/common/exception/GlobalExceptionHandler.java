package com.otcp.Accounting.common.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return createErrorResponse(ErrorConstants.VALIDATION_ERROR, ErrorConstants.VALIDATION_ERROR_MESSAGE, errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation ->
                errors.put(violation.getPropertyPath().toString(), violation.getMessage()));
        return createErrorResponse(ErrorConstants.CONSTRAINT_VIOLATION, ErrorConstants.CONSTRAINT_VIOLATION_MESSAGE, errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonParseException(HttpMessageNotReadableException ex) {
        return createErrorResponse(ErrorConstants.JSON_PARSE_ERROR, ErrorConstants.JSON_PARSE_ERROR_MESSAGE, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingRequestParameter(MissingServletRequestParameterException ex) {
        return createErrorResponse(ErrorConstants.MISSING_PARAMETER, ErrorConstants.MISSING_PARAMETER_MESSAGE + ": " + ex.getParameterName(), null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex) {
        return createErrorResponse(ErrorConstants.ENTITY_NOT_FOUND, ErrorConstants.ENTITY_NOT_FOUND_MESSAGE, null, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        return createErrorResponse(ErrorConstants.METHOD_NOT_ALLOWED, ErrorConstants.METHOD_NOT_ALLOWED_MESSAGE, null, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        return createErrorResponse(ErrorConstants.UNSUPPORTED_MEDIA_TYPE, ErrorConstants.UNSUPPORTED_MEDIA_TYPE_MESSAGE, null, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, Object>> handleHttpClientErrorException(HttpClientErrorException ex) {
        return createErrorResponse(ErrorConstants.HTTP_CLIENT_ERROR, ErrorConstants.HTTP_CLIENT_ERROR_MESSAGE, null, (HttpStatus) ex.getStatusCode());
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Map<String, Object>> handleResourceAccessException(ResourceAccessException ex) {
        return createErrorResponse(ErrorConstants.EXTERNAL_SERVICE_UNAVAILABLE, ErrorConstants.EXTERNAL_SERVICE_UNAVAILABLE_MESSAGE, null, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<Map<String, Object>> handleRestClientException(RestClientException ex) {
        return createErrorResponse(ErrorConstants.REST_CLIENT_ERROR, ErrorConstants.REST_CLIENT_ERROR_MESSAGE, null, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        return createErrorResponse(ErrorConstants.INTERNAL_SERVER_ERROR, ErrorConstants.INTERNAL_SERVER_ERROR_MESSAGE, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String, Object>> createErrorResponse(String errorCode, String message, Map<String, Object> details, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("errorCode", errorCode);
        response.put("message", message);
        if (details != null) {
            response.put("details", details);
        }
        return new ResponseEntity<>(response, status);
    }
}
