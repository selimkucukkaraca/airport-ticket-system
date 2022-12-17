package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.TicketDto;
import demo.airportticketsystem.dto.converter.TicketConverter;
import demo.airportticketsystem.dto.request.BuyTicketRequest;
import demo.airportticketsystem.dto.request.CreateCreditCardRequest;
import demo.airportticketsystem.dto.request.CreateTicketRequest;
import demo.airportticketsystem.model.Ticket;
import demo.airportticketsystem.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.function.Function;

@Service
public class TicketService {

    private final TicketConverter ticketConverter;
    private final TicketRepository ticketRepository;
    private final CreditCardService creditCardService;

    public TicketService(TicketConverter ticketConverter,
                         TicketRepository ticketRepository,
                         CreditCardService creditCardService) {
        this.ticketConverter = ticketConverter;
        this.ticketRepository = ticketRepository;
        this.creditCardService = creditCardService;
    }

    public void save(CreateTicketRequest request) {
        var ticket = ticketConverter.toEntity(request);
        ticketRepository.save(ticket);

        ticketConverter.convertTicketToTicketDto(ticket);
    }

    public TicketDto getTicketByTicketNumber(String ticketNumber) {
        return ticketConverter.convertTicketToTicketDto(ticketRepository.findTicketByTicketNumber(ticketNumber));
    }

    public TicketDto buyTicket(BuyTicketRequest request) {
        Ticket fromDbTicket = ticketRepository.findTicketByTicketNumber(request.getTicketNumber());

        fromDbTicket.setTicketAmount(fromDbTicket.getTicketAmount() - 1);

        if (fromDbTicket.getTicketAmount() == 0) {
            ticketRepository.delete(fromDbTicket);
        }
        int updatedPrice = (fromDbTicket.getPrice().intValue() * 10 / 100) + fromDbTicket.getPrice().intValue();

        fromDbTicket.setPrice(BigDecimal.valueOf(updatedPrice));

        ticketRepository.save(fromDbTicket);

        creditCardService.save(new CreateCreditCardRequest(
                maskCardNumber.apply(request.getCardNumber()),
                request.getNameAndLastname(),
                request.getCvv(),
                request.getExpirationDate()));
        return ticketConverter.convertTicketToTicketDto(fromDbTicket);
    }

    public Function<String, String> maskCardNumber = (cardNumber) -> {
        return cardNumber.substring(0, cardNumber.length() - 4).replaceAll("[0-9]", "*")
                + cardNumber.substring(cardNumber.length() - 4, cardNumber.length());
    };

}