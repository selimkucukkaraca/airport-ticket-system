package demo.airportticketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AirportDto {

    private String name;
    private String country;
    private String city;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
