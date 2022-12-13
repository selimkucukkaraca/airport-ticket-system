package demo.airportticketsystem.dto.request;

import demo.airportticketsystem.model.Route;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTicketRequest {
    private String ticketNumber;
    private int ticketAmount;
    private BigDecimal price;
    private String date;
    private Route route;
}
