package I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDetailDto;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.dto.CarDto;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.entity.Car;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.repository.CarRepository;
import I202012157.DAWI_Pajuelo_Torres_RobertoCarlos.service.CarManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarManageServiceImpl implements CarManageService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {
        List<Car> cars = (List<Car>) carRepository.findAll();
        List<CarDto> carDtos = new ArrayList<>();

        for (Car car : cars) {
            carDtos.add(new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getOwnerName(),
                    car.getLicensePlate()
            ));
        }

        return carDtos;
    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {
        Optional<Car> carOptional = carRepository.findById(id);

        return carOptional.map(car -> new CarDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()
        ));
    }

    @Override
    public boolean updateCar(CarDto carDto) throws Exception {
        Optional<Car> existingCarOptional = carRepository.findById(carDto.carId());

        if (existingCarOptional.isPresent()) {
            Car existingCar = existingCarOptional.get();
            existingCar.setMake(carDto.make());
            existingCar.setModel(carDto.model());
            existingCar.setOwnerName(carDto.ownerName());
            existingCar.setLicensePlate(carDto.licensePlate());

            carRepository.save(existingCar);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteCarById(int id) throws Exception {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {
        Car car = new Car(
                null,
                carDetailDto.make(),
                carDetailDto.model(),
                carDetailDto.year(),
                carDetailDto.vin(),
                carDetailDto.licensePlate(),
                carDetailDto.ownerName(),
                carDetailDto.ownerContact(),
                carDetailDto.purchaseDate(),
                carDetailDto.mileage(),
                carDetailDto.engineType(),
                carDetailDto.color(),
                carDetailDto.insuranceCompany(),
                carDetailDto.insurancePolicyNumber(),
                carDetailDto.registrationExpirationDate(),
                carDetailDto.serviceDueDate()
        );

        carRepository.save(car);
        return true;
    }
}
