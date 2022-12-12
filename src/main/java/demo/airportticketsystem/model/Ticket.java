package demo.airportticketsystem.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

}
