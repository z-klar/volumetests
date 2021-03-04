package cz.zk.volumetests.exception;

import cz.zk.volumetests.model.CustomHttpExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(mainException.class)
    public ResponseEntity<CustomHttpExceptionResponse> handleUserInvalidEmailException(mainException ex, WebRequest request) {
        log.warn("Generic error: " + request.toString());
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body(new CustomHttpExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Generic Error", ex.getMessage()));
    }

    @ExceptionHandler(fileNotFoundException.class)
    public ResponseEntity<CustomHttpExceptionResponse> handleFileNotFound(fileNotFoundException ex, WebRequest request) {
        log.warn("File not found: " + request.toString());
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST).
                body(new CustomHttpExceptionResponse(HttpStatus.NOT_FOUND, "File not found", ex.getMessage()));
    }
}
