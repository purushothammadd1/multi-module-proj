package com.movie.booking.system.api;

import com.movie.booking.system.services.BookingService;

import com.ticket.booking.system.commons.dto.BookingDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
@Slf4j
public class BookingAPI {
    @Autowired
    private BookingService bookingService;


    @PostMapping
    public BookingDTO createBooking(@Valid @RequestBody BookingDTO bookingDTO){
        log.info("Entered into BookingAPI with request {} ", bookingDTO.toString());
        return this.bookingService.createBooking (bookingDTO);
    }
}
/* @PostMapping
    public ResponseEntity<ResponseDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO){
        log.info("Entered into Booking API with JSON request: "+bookingDTO);
        ResponseDTO responseDTO = this.bookingService.createBooking(bookingDTO);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);

    }*/
