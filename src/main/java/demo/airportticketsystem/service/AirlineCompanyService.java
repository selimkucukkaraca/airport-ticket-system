package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.AirlineCompanyDto;
import demo.airportticketsystem.dto.converter.AirlineCompanyConverter;
import demo.airportticketsystem.dto.request.CreateAirlineCompanyRequest;
import demo.airportticketsystem.exception.NotFoundException;
import demo.airportticketsystem.exception.generic.GenericExistException;
import demo.airportticketsystem.model.AirlineCompany;
import demo.airportticketsystem.repository.AirlineCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineCompanyService {

    private final AirlineCompanyConverter airlineCompanyConverter;
    private final AirlineCompanyRepository airlineCompanyRepository;


    public AirlineCompanyService(AirlineCompanyConverter airlineCompanyConverter,
                                 AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyConverter = airlineCompanyConverter;
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public AirlineCompanyDto save(CreateAirlineCompanyRequest request) {
        var saved = airlineCompanyConverter.toEntity(request);

        if (airlineCompanyRepository.existsAirlineCompaniesByName(saved.getName())) {
            throw new GenericExistException(request.getName() + " exist");
        }
        airlineCompanyRepository.save(saved);
        return airlineCompanyConverter.converterAirlineCompanyToAirlineCompanyDto(saved);
    }

    public void delete(String name) {
        var fromAirlineCompany = getAirlineCompanyByName(name);
        airlineCompanyRepository.delete(fromAirlineCompany);
    }

    protected AirlineCompany getAirlineCompanyByName(String name) {
        return airlineCompanyRepository.findAirlineCompaniesByName(name)
                .orElseThrow(() ->new NotFoundException("airline company not found : " + name) );
    }

    public List<AirlineCompanyDto> getAll() {
        return airlineCompanyRepository.findAll()
                .stream()
                .map(airlineCompanyConverter::converterAirlineCompanyToAirlineCompanyDto)
                .collect(Collectors.toList());
    }

    public AirlineCompanyDto getAirlineCompanyByAirlineCompanyName(String name) {
        return airlineCompanyConverter.converterAirlineCompanyToAirlineCompanyDto
                (airlineCompanyRepository.findAirlineCompaniesByName(name)
                        .orElseThrow(() -> new NotFoundException("airline company not found : " + name)));
    }
}