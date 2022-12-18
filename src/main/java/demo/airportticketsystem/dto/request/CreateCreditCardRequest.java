package demo.airportticketsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCreditCardRequest {
    @NotBlank
    private String CardNumber;
    @NotBlank
    private String nameAndLastname;
    @NotNull
    private int cvv;
    @NotBlank
    private String expirationDate;
}
