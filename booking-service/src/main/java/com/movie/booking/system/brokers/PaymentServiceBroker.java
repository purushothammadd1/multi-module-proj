package com.movie.booking.system.brokers;


import com.ticket.booking.system.commons.dto.BookingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service" , url = "http://payment-service:9091/payments")
public interface PaymentServiceBroker {

    @PostMapping
    public BookingDTO makePayment(@RequestBody BookingDTO bookingDTO);
}
