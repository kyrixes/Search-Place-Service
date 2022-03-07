package com.example.placesearch.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ServerResponse<Object>> nullPointerException(final Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ServerResponse.rsp(e.getMessage()));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ServerResponse<Object>> illegalArgumentException(final Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ServerResponse.rsp(e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ServerResponse<Object>> allException(final Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ServerResponse.rsp(e.getMessage()));
    }
}
