package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Long> {

}
