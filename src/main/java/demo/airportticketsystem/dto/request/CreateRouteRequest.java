package demo.airportticketsystem.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateRouteRequest {
    private String landing;
    private String departure;
    private String airlineCompany;
    private int ticketAmount;
    private BigDecimal price;
    private String date;
}
