package demo.airportticketsystem.dto.converter;

import demo.airportticketsystem.dto.AirlineCompanyDto;
import demo.airportticketsystem.dto.AirportDto;
import demo.airportticketsystem.dto.request.CreateAirlineCompanyRequest;
import demo.airportticketsystem.dto.request.CreateAirportRequest;
import demo.airportticketsystem.model.Airport;
import org.springframework.stereotype.Component;

@Component
public class AirportConverter {

    public AirportDto convertAirportToAirportDto(Airport from){
        return new AirportDto(
                from.getName(),
                from.getCountry(),
                from.getCity(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Airport toEntity(CreateAirportRequest request){
        return new Airport(
                request.getName(),
                request.getCountry(),
                request.getCity()
        );
    }
}
