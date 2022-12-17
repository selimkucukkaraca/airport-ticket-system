package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RouteRepository extends JpaRepository<Route,Long> {

    //@Query("")
    //Route findRouteByLandingAndDeparture(String landing, String departure);

}
