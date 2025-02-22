package com.otcp.Accounting.common.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.MessageSource;
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
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex, Locale locale) {
        Map<String, Object> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), messageSource.getMessage(error.getDefaultMessage(), null, locale));
        }
        return createErrorResponse(
                messageSource.getMessage("VALIDATION_ERROR", null, locale),
                messageSource.getMessage("VALIDATION_ERROR_MESSAGE", null, locale),
                errors,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException ex, Locale locale) {
        Map<String, Object> errors = new HashMap<>();
        ex.getConstraintViolations().forEach(violation ->
                errors.put(violation.getPropertyPath().toString(), messageSource.getMessage(violation.getMessage(), null, locale)));
        return createErrorResponse(
                messageSource.getMessage("CONSTRAINT_VIOLATION", null, locale),
                messageSource.getMessage("CONSTRAINT_VIOLATION_MESSAGE", null, locale),
                errors,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, Object>> handleJsonParseException(HttpMessageNotReadableException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("JSON_PARSE_ERROR", null, locale),
                messageSource.getMessage("JSON_PARSE_ERROR_MESSAGE", null, locale),
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingRequestParameter(MissingServletRequestParameterException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("MISSING_PARAMETER", null, locale),
                messageSource.getMessage("MISSING_PARAMETER_MESSAGE", new Object[]{ex.getParameterName()}, locale),
                null,
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("ENTITY_NOT_FOUND", null, locale),
                messageSource.getMessage("ENTITY_NOT_FOUND_MESSAGE", null, locale),
                null,
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("METHOD_NOT_ALLOWED", null, locale),
                messageSource.getMessage("METHOD_NOT_ALLOWED_MESSAGE", null, locale),
                null,
                HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("UNSUPPORTED_MEDIA_TYPE", null, locale),
                messageSource.getMessage("UNSUPPORTED_MEDIA_TYPE_MESSAGE", null, locale),
                null,
                HttpStatus.UNSUPPORTED_MEDIA_TYPE
        );
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<Map<String, Object>> handleHttpClientErrorException(HttpClientErrorException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("HTTP_CLIENT_ERROR", null, locale),
                messageSource.getMessage("HTTP_CLIENT_ERROR_MESSAGE", null, locale),
                null,
                (HttpStatus) ex.getStatusCode()
        );
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Map<String, Object>> handleResourceAccessException(ResourceAccessException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("EXTERNAL_SERVICE_UNAVAILABLE", null, locale),
                messageSource.getMessage("EXTERNAL_SERVICE_UNAVAILABLE_MESSAGE", null, locale),
                null,
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    @ExceptionHandler(RestClientException.class)
    public ResponseEntity<Map<String, Object>> handleRestClientException(RestClientException ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("REST_CLIENT_ERROR", null, locale),
                messageSource.getMessage("REST_CLIENT_ERROR_MESSAGE", null, locale),
                null,
                HttpStatus.BAD_GATEWAY
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex, Locale locale) {
        return createErrorResponse(
                messageSource.getMessage("INTERNAL_SERVER_ERROR", null, locale),
                messageSource.getMessage("INTERNAL_SERVER_ERROR_MESSAGE", null, locale),
                null,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
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
