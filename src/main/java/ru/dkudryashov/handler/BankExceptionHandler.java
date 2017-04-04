package ru.dkudryashov.handler;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Created by Dmitry on 04.04.17.
 */
@ControllerAdvice
public class BankExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<String> handleException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(
                "Internal server error, contact the administrator",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(value = DataAccessException.class)
    protected ResponseEntity<String> handleExceptionNotFound(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }




}
