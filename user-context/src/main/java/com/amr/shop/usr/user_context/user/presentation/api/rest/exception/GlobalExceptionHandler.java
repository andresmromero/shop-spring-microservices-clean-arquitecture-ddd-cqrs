package com.amr.shop.usr.user_context.user.presentation.api.rest.exception;

import com.amr.shop.cmn.common_context._shared.exception.ExceptionDTO;
import com.amr.shop.usr.user_context.user.domain.UserEmailAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserEmailAlreadyExistException.class)
    public ResponseEntity<ExceptionDTO> handleUserEmailAlreadyExistException(
            UserEmailAlreadyExistException ex, WebRequest request) {
        ExceptionDTO errorDetails =
                new ExceptionDTO(HttpStatus.CONFLICT.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGlobalException(Exception ex, WebRequest request) {

        ExceptionDTO errorDetails = new ExceptionDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
