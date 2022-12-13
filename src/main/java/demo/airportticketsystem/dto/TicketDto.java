package demo.airportticketsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TicketDto {
    private String ticketNumber;
    private int ticketAmount;
    private BigDecimal price;
    private String date;
    private RouteDto routeDto;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
