package org.lester.springbootlearn.springbootmvc.advices;

import org.lester.springbootlearn.springbootmvc.exceptions.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundHandler(ResourceNotFoundException exception) {
        ApiError error = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message("Resource not found:" +exception.getMessage())
                .build();

        return buildErrorResponseEntity(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGlobalExceptionHandler(Exception exception) {
        ApiError error = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("Internal server error: " + exception.getMessage())
                .build();

        return buildErrorResponseEntity(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errorList = exception
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();

        ApiError error = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Validation error")
                .subErrors(errorList)
                .build();

        return buildErrorResponseEntity(error);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError error) {
        return new ResponseEntity<>(new ApiResponse<>(error), error.getStatus());
    }
}
