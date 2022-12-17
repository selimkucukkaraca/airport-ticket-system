package demo.airportticketsystem.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ticketNumber = UUID.randomUUID().toString();
    private int ticketAmount;
    private BigDecimal price;
    private String date;
    @ManyToOne
    private Route route;

    public Ticket(int ticketAmount, BigDecimal price, String date, Route route) {
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
