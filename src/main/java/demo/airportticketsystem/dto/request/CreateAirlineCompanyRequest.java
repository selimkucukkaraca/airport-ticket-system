package demo.airportticketsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CreateAirlineCompanyRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String country;
    private String mail;

}
