package com.movie.booking.system.handlers;

import com.ticket.booking.system.commons.handlers.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j

public class BookingAPIHandler extends GlobalExceptionHandler {
// To define handlers for custom defined booking related exceptions

}

/*log.info("Entered into bookingApiHandler class with the exception: " + exception.getMessage());
          List<ObjectError> errors  =exception.getBindingResult().getAllErrors();
          ResponseDTO responseDTO=ResponseDTO.builder()
               .errorMessage(errors.get(0).getDefaultMessage())
               .build();
*/
