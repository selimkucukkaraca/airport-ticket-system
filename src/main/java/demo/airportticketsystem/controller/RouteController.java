package demo.airportticketsystem.controller;

import demo.airportticketsystem.dto.RouteDto;
import demo.airportticketsystem.dto.request.CreateRouteRequest;
import demo.airportticketsystem.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
