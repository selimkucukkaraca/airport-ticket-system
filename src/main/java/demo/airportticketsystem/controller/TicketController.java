package demo.airportticketsystem.controller;

import demo.airportticketsystem.dto.TicketDto;
import demo.airportticketsystem.dto.request.BuyTicketRequest;
import demo.airportticketsystem.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/get-ticket-by-ticket-number")
    public ResponseEntity<TicketDto> getTicketByTicketNumber(@Valid @RequestParam String ticketNumber){
        return ResponseEntity
                .ok(ticketService.getTicketByTicketNumber(ticketNumber));
    }

    @PostMapping
    public ResponseEntity<TicketDto> buyTicket(@Valid @RequestBody BuyTicketRequest request){
        return ResponseEntity
                .ok(ticketService.buyTicket(request));
    }

}
