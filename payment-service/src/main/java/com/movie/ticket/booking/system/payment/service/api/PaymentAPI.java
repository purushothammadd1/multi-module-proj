package com.movie.ticket.booking.system.payment.service.api;

import com.movie.ticket.booking.system.payment.service.serviceslayer.PaymentService;
import com.ticket.booking.system.commons.dto.BookingDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("payments")
public class PaymentAPI {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public BookingDTO makePayment(@RequestBody BookingDTO bookingDTO){
        log.info("Entered into paymentAPI with the request {}", bookingDTO.toString ());
        return this.paymentService.makePayment (bookingDTO);
    }
}