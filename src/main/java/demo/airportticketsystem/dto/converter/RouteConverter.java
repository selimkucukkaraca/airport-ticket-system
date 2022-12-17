package demo.airportticketsystem.dto.converter;

import demo.airportticketsystem.dto.RouteDto;
import demo.airportticketsystem.dto.request.CreateRouteRequest;
import demo.airportticketsystem.model.AirlineCompany;
import demo.airportticketsystem.model.Airport;
import demo.airportticketsystem.model.Route;
import org.springframework.stereotype.Component;


@Component
public class RouteConverter {

    private final AirlineCompanyConverter airlineCompanyConverter;
    private final AirportConverter airportConverter;


    public RouteConverter(AirlineCompanyConverter airlineCompanyConverter,
                          AirportConverter airportConverter) {
        this.airlineCompanyConverter = airlineCompanyConverter;
        this.airportConverter = airportConverter;
    }


    public RouteDto converterRouteToRouteDto(Route from){
        return new RouteDto(
                airportConverter.convertAirportToAirportDto(from.getLanding()),
                airportConverter.convertAirportToAirportDto(from.getDeparture()),
                airlineCompanyConverter.converterAirlineCompanyToAirlineCompanyDto(from.getAirlineCompany()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Route toEntity(Airport landing, Airport departure, AirlineCompany airlineCompany){
        return new Route(
                landing,
                departure,
                airlineCompany
        );
    }
}
