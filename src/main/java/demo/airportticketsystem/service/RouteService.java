package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.RouteDto;
import demo.airportticketsystem.dto.converter.RouteConverter;
import demo.airportticketsystem.dto.request.CreateRouteRequest;
import demo.airportticketsystem.dto.request.CreateTicketRequest;
import demo.airportticketsystem.model.AirlineCompany;
import demo.airportticketsystem.model.Airport;
import demo.airportticketsystem.repository.RouteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteConverter routeConverter;
    private final RouteRepository routeRepository;
    private final AirportService airportService;
    private final AirlineCompanyService airlineCompanyService;
    private final TicketService ticketService;

    public RouteService(RouteConverter routeConverter,
                        RouteRepository routeRepository,
                        AirportService airportService,
                        AirlineCompanyService airlineCompanyService,
                        TicketService ticketService) {
        this.routeConverter = routeConverter;
        this.routeRepository = routeRepository;
        this.airportService = airportService;
        this.airlineCompanyService = airlineCompanyService;
        this.ticketService = ticketService;
    }

    @Transactional
    public RouteDto save(CreateRouteRequest request) {
        Airport landing = airportService.getAirportByName(request.getLanding());
        Airport departure = airportService.getAirportByName(request.getDeparture());
        AirlineCompany airlineCompany = airlineCompanyService.getAirlineCompanyByName(request.getAirlineCompany());

        var saved = routeConverter.toEntity(landing, departure, airlineCompany);

        ticketService.save(new CreateTicketRequest(
                request.getTicketAmount(),
                request.getPrice(),
                request.getDate(),
                saved));

        routeRepository.save(saved);
        return routeConverter.converterRouteToRouteDto(saved);
    }

    public List<RouteDto> getRouteByLandingAndDeparture(String landing, String departure) {
        return routeRepository.findAll()
                .stream()
                .filter(route -> route.getLanding().getName().equals(landing) &&
                        route.getDeparture().getName().equals(departure))
                .map(routeConverter::converterRouteToRouteDto)
                .collect(Collectors.toList());
    }

}
