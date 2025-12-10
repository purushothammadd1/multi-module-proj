package com.movie.ticket.booking.system.payment.service.repositories;

import com.movie.ticket.booking.system.payment.service.entity.PaymentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends CrudRepository<PaymentEntity, UUID> {

}
