package com.movie.booking.system.repositories;

import com.movie.booking.system.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, UUID> {

}
