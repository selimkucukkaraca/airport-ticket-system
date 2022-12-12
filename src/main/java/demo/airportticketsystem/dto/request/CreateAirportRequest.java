package demo.airportticketsystem.dto.request;

import lombok.Data;

@Data
public class CreateAirportRequest {
    private String name;
    private String country;
    private String city;
}
