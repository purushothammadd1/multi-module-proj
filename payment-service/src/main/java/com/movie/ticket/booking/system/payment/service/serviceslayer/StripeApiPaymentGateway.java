package com.movie.ticket.booking.system.payment.service.serviceslayer;

import com.movie.booking.system.entity.BookingStatus;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.ticket.booking.system.commons.dto.BookingDTO;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class StripeApiPaymentGateway {

    @Value("${stripe.key}")
    private String secretKey;

    @PostConstruct
    public void init(){
        Stripe.apiKey = secretKey;
    }
    public BookingDTO processPayment(BookingDTO bookingDTO){
        log.info("Entered into StripeAPIPaymentGateway for doing the payment for booking id {} ", bookingDTO.getBookingId ());
        Map<String, Object> chargeParams = new HashMap<> ();
        chargeParams.put ("amount",(int) Math.round ( bookingDTO.getBookingAmount () ) * 100);
        chargeParams.put ("currency" , "INR");
        chargeParams.put ("description", "Test payment for Booking service");
        chargeParams.put ("source","tok_amex");
        try {
            Charge.create (chargeParams); // create online payment
            log.info("payment was successful for the booking Id {} ",bookingDTO.getBookingId ());
            bookingDTO.setBookingStatus ( BookingStatus.CONFIRMED);
        } catch (StripeException e) {
            log.error ("Error Encountered during payment process: "+ e.getMessage ());
            bookingDTO.setBookingStatus (BookingStatus.CANCELLED);
        }
        return bookingDTO;
    }
}
