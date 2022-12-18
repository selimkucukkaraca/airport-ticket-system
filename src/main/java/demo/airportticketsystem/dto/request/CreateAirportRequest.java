package demo.airportticketsystem.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAirportRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String country;
    @NotBlank
    private String city;
}
