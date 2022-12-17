package demo.airportticketsystem.repository;


import demo.airportticketsystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket findTicketByTicketNumber(String ticketNumber);
}
