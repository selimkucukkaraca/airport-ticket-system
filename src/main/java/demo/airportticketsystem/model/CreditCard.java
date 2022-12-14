package demo.airportticketsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CardNumber;
    private String nameAndLastname;
    private int cvv;
    private String expirationDate;

    public CreditCard(String cardNumber, String nameAndLastname, int cvv, String expirationDate) {
        CardNumber = cardNumber;
        this.nameAndLastname = nameAndLastname;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }


}
