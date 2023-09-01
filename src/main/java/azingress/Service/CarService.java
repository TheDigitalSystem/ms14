package azingress.Service;

import azingress.Dto.CarRequestDto;
import azingress.Dto.CarResponseDto;
import azingress.Entity.Car;
import azingress.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService implements CarServiceImpl {


    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
@Override
    public List<CarResponseDto> findAll(){
return carRepository
        .findAll()
        .stream()
        .map(car -> modelMapper.map(car, CarResponseDto.class))
        .collect(Collectors.toList());
    }



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

    @Override
public void update(Long id, CarRequestDto carRequestDto){
    Car car = carRepository.findById(id).get();
    car.setCarColor(carRequestDto.getCarColor());
    car.setYear(carRequestDto.getYear());
    car.setEngine(carRequestDto.getEngine());
    car.setModel(carRequestDto.getModel());
    car.setMaker(carRequestDto.getMaker());
    carRepository.save(car);

}

public void delete(Long id){
    carRepository.deleteById(id);
}



}
