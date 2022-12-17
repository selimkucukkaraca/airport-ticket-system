package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.converter.CreditCardConverter;
import demo.airportticketsystem.dto.request.CreateCreditCardRequest;
import demo.airportticketsystem.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    private final CreditCardRepository creditCardRepository;
    private final CreditCardConverter creditCardConverter;


    public CreditCardService(CreditCardRepository creditCardRepository,
                             CreditCardConverter creditCardConverter) {
        this.creditCardRepository = creditCardRepository;
        this.creditCardConverter = creditCardConverter;
    }

    public void save(CreateCreditCardRequest request) {
        var saved = creditCardConverter.toEntity(request);
        creditCardRepository.save(saved);
    }


}
