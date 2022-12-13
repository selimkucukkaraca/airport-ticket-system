package demo.airportticketsystem.controller;

import demo.airportticketsystem.dto.AirportDto;
import demo.airportticketsystem.dto.request.CreateAirportRequest;
import demo.airportticketsystem.service.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<AirportDto> save(@RequestBody CreateAirportRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(airportService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<AirportDto>> getAll(){
        return ResponseEntity
                .ok(airportService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(String name){
        airportService.delete(name);
        return ResponseEntity.noContent().build();
    }
}