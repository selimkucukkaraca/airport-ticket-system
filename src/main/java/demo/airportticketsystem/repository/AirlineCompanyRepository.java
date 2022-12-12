package demo.airportticketsystem.repository;

import demo.airportticketsystem.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Long> {
}
