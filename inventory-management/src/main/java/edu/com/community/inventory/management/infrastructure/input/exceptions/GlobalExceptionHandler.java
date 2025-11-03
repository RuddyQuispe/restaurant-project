package edu.com.community.inventory.management.infrastructure.input.exceptions;

import edu.com.community.inventory.management.domain.exception.ModelNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = ModelNotFoundException.class, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GlobalError> handleModelNotFoundException(ModelNotFoundException exception) {
        GlobalError error = new GlobalError(exception.getMessage(), null, LocalDateTime.now());
        log.error("Exception ModelNotFoundException response: {}", error);
        return ResponseEntity.badRequest().body(error);
    }
}
