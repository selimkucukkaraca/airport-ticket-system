package demo.airportticketsystem.dto.converter;

import demo.airportticketsystem.dto.TicketDto;
import demo.airportticketsystem.dto.request.CreateTicketRequest;
import demo.airportticketsystem.model.Ticket;
import org.springframework.stereotype.Component;



@Component
public class TicketConverter {

    private final RouteConverter routeConverter;

    public TicketConverter(RouteConverter routeConverter) {
        this.routeConverter = routeConverter;
    }

    public TicketDto convertTicketToTicketDto(Ticket from){
        return new TicketDto(
                from.getTicketNumber(),
                from.getTicketAmount(),
                from.getPrice(),
                from.getDate(),
                routeConverter.converterRouteToRouteDto(from.getRoute()),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public Ticket toEntity(CreateTicketRequest request){
        return new Ticket(
                request.getTicketNumber(),
                request.getTicketAmount(),
                request.getPrice(),
                request.getDate(),
                request.getRoute()
        );
    }
}
