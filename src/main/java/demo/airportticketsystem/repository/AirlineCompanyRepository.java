package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {

    boolean existsAirlineCompaniesByName(String airlineCompanyName);
    AirlineCompany findAirlineCompaniesByName(String name);

}
