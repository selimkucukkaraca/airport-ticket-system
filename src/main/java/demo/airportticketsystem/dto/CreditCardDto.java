package demo.airportticketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreditCardDto {
    private String CardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
