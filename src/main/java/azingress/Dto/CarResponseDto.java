package azingress.Dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CarResponseDto {
    private String model;
    private String maker;
    private String engine;
    private String carColor;
    private LocalDate year;
}
