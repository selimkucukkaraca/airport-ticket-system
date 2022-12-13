package demo.airportticketsystem.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @GeneratedValue(strategy = GenerationType.AUTO) // TODO chech
    private String ticketNumber;
    private int ticketAmount;
    private BigDecimal price;
    private String date;
    @ManyToOne
    private Route route;

    public Ticket(String ticketNumber, int ticketAmount, BigDecimal price, String date, Route route) {
        this.ticketNumber = ticketNumber;
        this.ticketAmount = ticketAmount;
        this.price = price;
        this.date = date;
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ticket ticket = (Ticket) o;
        return id != null && Objects.equals(id, ticket.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
