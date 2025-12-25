package com.movie.booking.system.services.impl;

import com.movie.booking.system.brokers.PaymentServiceBroker;
import com.movie.booking.system.entity.BookingEntity;
import com.movie.booking.system.repositories.BookingRepository;
import com.movie.booking.system.services.BookingService;
import com.ticket.booking.system.commons.dto.BookingDTO;
import com.ticket.booking.system.commons.status.BookingStatus;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentServiceBroker paymentService;

    @Override
    @Transactional
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        log.info("Entered into BookingServiceImpl with request {}" , bookingDTO.toString());
        BookingEntity bookingEntity = BookingEntity.builder()
        		.userId(bookingDTO.getUserId())
        		.movieId(bookingDTO.getMovieId())
                .bookingAmount(bookingDTO.getBookingAmount())
                .bookingStatus(BookingStatus.PENDING)
                .showDate(bookingDTO.getShowDate())
                .showTime(bookingDTO.getShowTime())
                .seatsSelected(bookingDTO.getSeatsSelected())
                .build();
        this.bookingRepository.save(bookingEntity);
        bookingDTO.setBookingId (bookingEntity.getBookingId ());
//        bookingDTO.setBookingStatus (BookingStatus.PENDING);
        //call payment service
        log.info("calling Stripe payment gateway to do payment for the amount {} with booking Id {}",bookingEntity.getBookingAmount (),bookingEntity.getBookingId ());
        BookingDTO bookingPaymentResponse = this.paymentService.makePayment (bookingDTO);
        log.info ( "payment was successful with bookingId {}", bookingEntity.getBookingId () );

        bookingEntity.setBookingStatus(bookingPaymentResponse.getBookingStatus());
       return BookingDTO.builder()
               .bookingId ( bookingEntity.getBookingId())
               .bookingStatus (BookingStatus.CONFIRMED)
               .userId ( bookingEntity.getUserId () )
               .movieId ( bookingEntity.getMovieId () )
               .bookingAmount ( bookingEntity.getBookingAmount () )
               .showDate ( bookingEntity.getShowDate () )
               .showTime ( bookingEntity.getShowTime () )
               .seatsSelected ( bookingEntity.getSeatsSelected () )
               .build ();
    }
}