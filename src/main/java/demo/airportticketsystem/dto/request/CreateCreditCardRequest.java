package demo.airportticketsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCreditCardRequest {
    private String CardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;
}
