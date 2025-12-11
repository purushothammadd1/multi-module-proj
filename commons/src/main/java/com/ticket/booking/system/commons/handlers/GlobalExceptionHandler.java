package com.ticket.booking.system.commons.handlers;

import com.ticket.booking.system.commons.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<ResponseDTO> (ResponseDTO.builder ()
                .errorDescription (HttpStatus.BAD_REQUEST.getReasonPhrase ())
                .errorMessage (
                        methodArgumentNotValidException.getBindingResult ().getAllErrors ()
                                .stream ()
                                .map ( ObjectError :: getDefaultMessage)
                                .collect ( Collectors.toList ())
                )
                .build (), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDTO> RuntimeException(RuntimeException runtimeException){
        return new ResponseEntity<ResponseDTO> (
                ResponseDTO.builder ()
                        .statusCodeDescription (HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .errorDescription (runtimeException.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
