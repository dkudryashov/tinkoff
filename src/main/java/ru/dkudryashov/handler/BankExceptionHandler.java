package ru.dkudryashov.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Dmitry on 04.04.17.
 */
@ControllerAdvice
public class BankExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(BankExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    void handleException(HttpServletResponse response, RuntimeException ex) throws IOException {
        logger.error("Exception in server: {}", ex.getMessage());
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataAccessException.class)
    protected ResponseEntity<String> handleExceptionNotFound(DataAccessException ex, WebRequest request) {
        String body = Objects.nonNull(ex) && Objects.nonNull(ex.getCause()) ? ex.getCause().getMessage() : "Database error";
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}
