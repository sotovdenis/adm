package gpb.adminka.api.controller;

import gpb.adminka.model.Car;
import gpb.adminka.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Car>> getAllCars() {
        return ResponseEntity.ok(carRepository.getCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable int id) {
        Car car = carRepository.getCar(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        carRepository.getCars().put(car.getId(), car);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car updatedCar) {
        Car existingCar = carRepository.getCar(id);
        if (existingCar != null) {
            updatedCar.setId(id);
            carRepository.getCars().put(id, updatedCar);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        Car car = carRepository.getCar(id);
        if (car != null) {
            carRepository.getCars().remove(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/mechanic/{mechanicId}")
    public ResponseEntity<List<Car>> getCarsByMechanicId(@PathVariable int mechanicId) {
        List<Car> cars = carRepository.getAllCarWithMechanicId(mechanicId);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}