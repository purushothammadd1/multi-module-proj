package com.movie.ticket.booking.system.payment.service.serviceslayer;

import com.ticket.booking.system.commons.dto.BookingDTO;

public interface PaymentService {

    public BookingDTO makePayment(BookingDTO bookingDTO);
}
