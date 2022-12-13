package demo.airportticketsystem.dto.converter;

import demo.airportticketsystem.dto.CreditCardDto;
import demo.airportticketsystem.dto.request.CreateCreditCardRequest;
import demo.airportticketsystem.model.CreditCard;
import org.springframework.stereotype.Component;

@Component
public class CreditCardConverter {

    public CreditCardDto convertCreditCardToCreditCardDto(CreditCard from){
        return new CreditCardDto(
                from.getCardNumber(),
                from.getNameAndLastname(),
                from.getCvv(),
                from.getExpirationDate(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public CreditCard toEntity(CreateCreditCardRequest request){
        return new CreditCard(
                request.getCardNumber(),
                request.getNameAndLastname(),
                request.getCvv(),
                request.getExpirationDate()
        );
    }

}
