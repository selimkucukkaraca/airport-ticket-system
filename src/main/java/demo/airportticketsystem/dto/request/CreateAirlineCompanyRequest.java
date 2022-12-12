package demo.airportticketsystem.dto.request;

import lombok.Data;

@Data
public class CreateAirlineCompanyRequest {
    private String name;
    private String country;
    private String mail;

}
