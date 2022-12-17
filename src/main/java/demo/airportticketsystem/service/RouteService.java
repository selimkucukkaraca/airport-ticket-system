package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.RouteDto;
import demo.airportticketsystem.dto.converter.RouteConverter;
import demo.airportticketsystem.dto.request.CreateRouteRequest;
import demo.airportticketsystem.model.AirlineCompany;
import demo.airportticketsystem.model.Airport;
import demo.airportticketsystem.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final RouteConverter routeConverter;
    private final RouteRepository routeRepository;
    private final AirportService airportService;
    private final AirlineCompanyService airlineCompanyService;

    public RouteService(RouteConverter routeConverter,
                        RouteRepository routeRepository,
                        AirportService airportService,
                        AirlineCompanyService airlineCompanyService) {
        this.routeConverter = routeConverter;
        this.routeRepository = routeRepository;
        this.airportService = airportService;
        this.airlineCompanyService = airlineCompanyService;
    }

    public RouteDto save(CreateRouteRequest request){
        Airport landing = airportService.getAirportByName(request.getLanding());
        Airport departure = airportService.getAirportByName(request.getDeparture());
        AirlineCompany airlineCompany = airlineCompanyService.getAirlineCompanyByName(request.getAirlineCompany());

        var saved = routeConverter.toEntity(landing, departure, airlineCompany);

        routeRepository.save(saved);
        return routeConverter.converterRouteToRouteDto(saved);
    }



}
