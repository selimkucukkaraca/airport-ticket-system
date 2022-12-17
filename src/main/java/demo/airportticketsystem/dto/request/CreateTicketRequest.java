package demo.airportticketsystem.dto.request;

import demo.airportticketsystem.model.Route;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateTicketRequest {
    private int ticketAmount;
    private BigDecimal price;
    private String date;
    private Route route;
}
