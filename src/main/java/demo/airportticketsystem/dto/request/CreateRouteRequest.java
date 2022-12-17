package demo.airportticketsystem.dto.request;

import lombok.Data;

@Data
public class CreateRouteRequest {
    private String landing;
    private String departure;
    private String airlineCompany;
}
