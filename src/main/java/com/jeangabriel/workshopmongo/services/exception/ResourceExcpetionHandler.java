package com.jeangabriel.workshopmongo.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExcpetionHandler {

    @ExceptionHandler(ObjectNotFoundExpection.class)
    public ResponseEntity<StandardError>
    objectNotFound(ObjectNotFoundExpection e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),
                httpStatus.value(),
                "Não encontrado",
                e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(httpStatus).body(err);
    }
}
