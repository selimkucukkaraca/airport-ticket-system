package demo.airportticketsystem.controller;

import demo.airportticketsystem.dto.RouteDto;
import demo.airportticketsystem.dto.request.CreateRouteRequest;
import demo.airportticketsystem.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<RouteDto> save(@RequestBody CreateRouteRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(routeService.save(request));
    }

    @GetMapping("/get-by-departure-and-landing")
    public ResponseEntity<List<RouteDto>> getRouteByLandingAndDeparture(@RequestParam String landing, @RequestParam String departure) {
        return ResponseEntity
                .ok(routeService.getRouteByLandingAndDeparture(landing, departure));
    }
}
