package demo.airportticketsystem.service;

import demo.airportticketsystem.dto.AirportDto;
import demo.airportticketsystem.dto.converter.AirportConverter;
import demo.airportticketsystem.dto.request.CreateAirportRequest;
import demo.airportticketsystem.model.Airport;
import demo.airportticketsystem.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportConverter airportConverter;
    private final AirportRepository airportRepository;

    public AirportService(AirportConverter airportConverter,
                          AirportRepository airportRepository) {
        this.airportConverter = airportConverter;
        this.airportRepository = airportRepository;
    }


    public AirportDto save(CreateAirportRequest request){
        var saved = airportConverter.toEntity(request);

        if (airportRepository.existsAirportByName(saved.getName())){
            throw new RuntimeException();
        }
        airportRepository.save(saved);
        return airportConverter.convertAirportToAirportDto(saved);
    }


    public void delete(String name){
        var fromAirport = getAirportByName(name);
        airportRepository.delete(fromAirport);
    }

    protected Airport getAirportByName(String name){
        return airportRepository.findAirportByName(name);
    }

    public List<AirportDto> getAll(){
        return airportRepository.findAll()
                .stream()
                .map(airportConverter::convertAirportToAirportDto)
                .collect(Collectors.toList());
    }

    public AirportDto getAirportByAirportName(String name){
        return airportConverter.convertAirportToAirportDto(airportRepository.findAirportByName(name));

    }




}
