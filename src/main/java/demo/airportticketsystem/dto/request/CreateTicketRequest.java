package demo.airportticketsystem.dto.request;

import demo.airportticketsystem.model.Route;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateTicketRequest {
    @NotNull
    private int ticketAmount;
    @NotNull
    private BigDecimal price;
    @NotBlank
    private String date;
    @NotBlank
    private Route route;
}
