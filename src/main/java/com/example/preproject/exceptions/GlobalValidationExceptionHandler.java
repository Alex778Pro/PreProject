//package com.example.preproject.exceptions;
//
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalValidationExceptionHandler extends ResponseEntityExceptionHandler {
//
//    /**
//     * Метод для обработки нарушенных условий валидации
//     */
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatusCode status,
//            WebRequest request) {
//
//        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
//        Map<String, String> errorMessages = new HashMap<>();
//
//        // Формируем структуру с информацией об ошибках
//        for (FieldError error : errors) {
//            errorMessages.put(error.getField(), error.getDefaultMessage());
//        }
//
//        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST); // Статус 400 Bad Request
//    }
//}