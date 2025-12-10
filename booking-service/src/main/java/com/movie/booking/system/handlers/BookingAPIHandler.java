package com.movie.booking.system.handlers;

import com.movie.booking.system.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j

public class BookingAPIHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDTO> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        return new ResponseEntity<ResponseDTO> (ResponseDTO.builder ()
                .errorDescription (HttpStatus.BAD_REQUEST.getReasonPhrase ())
                .errorMessage (
                        methodArgumentNotValidException.getBindingResult ().getAllErrors ()
                                .stream ()
                                .map (ObjectError :: getDefaultMessage)
                                .collect (Collectors.toList ())
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
/*log.info("Entered into bookingApiHandler class with the exception: " + exception.getMessage());
          List<ObjectError> errors  =exception.getBindingResult().getAllErrors();
          ResponseDTO responseDTO=ResponseDTO.builder()
               .errorMessage(errors.get(0).getDefaultMessage())
               .build();
*/
