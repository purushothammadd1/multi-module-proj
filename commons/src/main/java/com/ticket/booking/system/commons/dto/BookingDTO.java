package com.ticket.booking.system.commons.dto;

import com.movie.booking.system.entity.BookingStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data@AllArgsConstructor@NoArgsConstructor@Validated@Builder
public class BookingDTO {
    private UUID bookingId;
    @NotBlank(message = "User Id is mandatory")
    private String userId;
    @NotNull(message = "movieId is mandatory")
    @Positive(message = "please provide a valid movie id")
    private Integer movieId;
    @NotNull(message = "You need to select at least one seat to create booking")
    private List<String> seatsSelected;
    @NotNull(message = "Select the show date")
    private LocalDate showDate;
    @NotNull(message = "select a show time")
    private LocalTime showTime;
    @NotNull(message = "booking amount is mandatory")
    @Positive(message = "Booking amount must be a positive value")
    private Double bookingAmount;
    private BookingStatus bookingStatus;
}
