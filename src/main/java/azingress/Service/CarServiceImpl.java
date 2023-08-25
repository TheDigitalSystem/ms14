package azingress.Service;

import azingress.Dto.CarRequestDto;
import azingress.Dto.CarResponseDto;

public interface CarServiceImpl {
    public void createCar(CarRequestDto carRequestDto);

    CarResponseDto getCarById(Long id);
}
