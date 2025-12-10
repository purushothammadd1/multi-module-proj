package com.ticket.booking.system.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ResponseDTO {
    private List<String> errorMessage;
    private String statusCodeDescription;
    private String errorDescription;
    private BookingDTO bookingDTO;
}
