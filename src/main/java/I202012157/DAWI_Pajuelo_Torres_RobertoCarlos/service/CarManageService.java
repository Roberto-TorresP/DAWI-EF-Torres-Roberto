package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.service;

import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDetailDto;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDto;
import java.util.List;
import java.util.Optional;

public interface CarManageService {
    List<CarDto> getAllCars() throws Exception;
    Optional<CarDetailDto> getCarById(int id) throws Exception;
    boolean updateCar(CarDto carDto) throws Exception;
    boolean deleteCarById(int id) throws Exception;
    boolean addCar(CarDetailDto carDetailDto) throws Exception;
}
