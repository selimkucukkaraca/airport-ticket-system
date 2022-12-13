package demo.airportticketsystem.dto.request;

import demo.airportticketsystem.model.AirlineCompany;
import demo.airportticketsystem.model.Airport;
import lombok.Data;

@Data
public class CreateRouteRequest {
    private Airport landing;
    private Airport departure;
    private AirlineCompany airlineCompany;
}
