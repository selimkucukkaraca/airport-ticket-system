package demo.airportticketsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyTicketRequest {
    @NotBlank
    private String ticketNumber;
    @NotBlank
    private String nameAndLastname;
    @NotBlank
    private String cardNumber;
    @NotBlank
    private int cvv;
    @NotNull
    private String expirationDate;

}
