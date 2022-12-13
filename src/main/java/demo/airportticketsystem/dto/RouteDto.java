package demo.airportticketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class RouteDto {
    private AirportDto landing;
    private AirportDto departure;
    private AirlineCompanyDto airlineCompanydto;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
