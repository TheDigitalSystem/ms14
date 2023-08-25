package azingress.Controller;

import azingress.Dto.CarRequestDto;
import azingress.Dto.CarResponseDto;
import azingress.Service.CarService;
import azingress.Service.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarServiceImpl carServiceImpl;

    @PostMapping() //bu hisseni tuta bilmedim, sual verersen
    public void create(@RequestBody CarRequestDto carRequestDto){
        carServiceImpl.createCar(carRequestDto);
    }

    @GetMapping("/{id}") // bu hissenide tam tutmadim
public CarResponseDto getCarByID(@PathVariable Long id){
        return  carServiceImpl.getCarById(id);
    }
}
