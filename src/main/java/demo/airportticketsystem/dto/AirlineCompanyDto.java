package demo.airportticketsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AirlineCompanyDto {

    private String name;
    private String country;
    private String mail;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
