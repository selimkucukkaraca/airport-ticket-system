package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport,Long> {

    boolean existsAirportByName(String airportName);
    Optional<Airport> findAirportByName(String name);

}
