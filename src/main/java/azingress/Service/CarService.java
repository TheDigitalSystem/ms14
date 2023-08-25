package azingress.Service;

import azingress.Dto.CarRequestDto;
import azingress.Dto.CarResponseDto;
import azingress.Entity.Car;
import azingress.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService implements CarServiceImpl {


    private final ModelMapper modelMapper;
    private final CarRepository carRepository;


    @Override
    public void createCar(CarRequestDto carRequestDto) { //hemcincin burda cagirilma sohbetini tutmamisan. YATMA !! ARASHDIR

        Car car = modelMapper.map(carRequestDto, Car.class);
        carRepository.save(car);
        //bu kodun mentiqi Car classina ADD elemek ucunndu
    }       // ID ni requeste gorterme, GENERATED VALUE sohbetine gore ozu artiracaq bazaya sene de problem yaratmayacaq


    @Override
    public CarResponseDto getCarById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return modelMapper.map(car, CarResponseDto.class);
    }

}
