package demo.airportticketsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateRouteRequest {
    @NotBlank
    private String landing;
    @NotBlank
    private String departure;
    @NotBlank
    private String airlineCompany;
    @NotNull
    private int ticketAmount;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String date;
}
