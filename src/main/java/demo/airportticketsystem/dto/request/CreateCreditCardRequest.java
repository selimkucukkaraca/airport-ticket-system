package demo.airportticketsystem.dto.request;

import lombok.Data;

@Data
public class CreateCreditCardRequest {
    private String CardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;
}
