package azingress.Service;

import azingress.Dto.CarRequestDto;
import azingress.Dto.CarResponseDto;

import java.util.List;

public interface CarServiceImpl {
    public void createCar(CarRequestDto carRequestDto);

    CarResponseDto getCarById(Long id);
    List<CarResponseDto> findAll();
    public void update(Long id, CarRequestDto carRequestDto);

    public void delete(Long id);
}
