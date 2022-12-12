package demo.airportticketsystem.dto.converter;

import demo.airportticketsystem.dto.AirlineCompanyDto;
import demo.airportticketsystem.dto.request.CreateAirlineCompanyRequest;
import demo.airportticketsystem.model.AirlineCompany;
import org.springframework.stereotype.Component;

@Component
public class AirlineCompanyConverter {

    public AirlineCompanyDto converterAirlineCompanyToAirlineCompanyDto(AirlineCompany from){
        return new AirlineCompanyDto(
                from.getName(),
                from.getCountry(),
                from.getMail(),
                from.getCreateDate(),
                from.getUpdateDate()
        );
    }

    public AirlineCompany toEntity(CreateAirlineCompanyRequest request){
        return new AirlineCompany(
                request.getName(),
                request.getCountry(),
                request.getMail()
        );
    }


}
