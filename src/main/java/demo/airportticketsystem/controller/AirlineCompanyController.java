package demo.airportticketsystem.controller;

import demo.airportticketsystem.dto.AirlineCompanyDto;
import demo.airportticketsystem.dto.request.CreateAirlineCompanyRequest;
import demo.airportticketsystem.service.AirlineCompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airline-company")
public class AirlineCompanyController {

    private final AirlineCompanyService airlineCompanyService;

    public AirlineCompanyController(AirlineCompanyService airlineCompanyService) {
        this.airlineCompanyService = airlineCompanyService;
    }

    @PostMapping
    public ResponseEntity<AirlineCompanyDto> save(@Valid @RequestBody CreateAirlineCompanyRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(airlineCompanyService.save(request));
    }

    @GetMapping
    public ResponseEntity<List<AirlineCompanyDto>> getAll(){
        return ResponseEntity
                .ok(airlineCompanyService.getAll());
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String name){
        airlineCompanyService.delete(name);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-by-airline-company-name")
    public ResponseEntity<?> getAirlineCompanyByName(@RequestParam String name){
        airlineCompanyService.getAirlineCompanyByAirlineCompanyName(name);
        return ResponseEntity
                .ok(airlineCompanyService.getAirlineCompanyByAirlineCompanyName(name));
    }

}
