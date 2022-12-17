package demo.airportticketsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyTicketRequest {
    private String ticketNumber;
    private String nameAndLastname;
    private String cardNumber;
    private int cvv;
    private String expirationDate;

}
