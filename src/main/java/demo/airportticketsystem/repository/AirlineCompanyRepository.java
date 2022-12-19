package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {

    boolean existsAirlineCompaniesByName(String airlineCompanyName);
    Optional<AirlineCompany> findAirlineCompaniesByName(String name);

}
