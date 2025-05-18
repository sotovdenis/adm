package gpb.adminka.repository;

import gpb.adminka.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CarRepository {
    private HashMap<Integer, Car> cars = new HashMap<>();

    public CarRepository() {}

    public CarRepository(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }

    public void setCars(HashMap<Integer, Car> cars) {
        this.cars.putAll(cars);
    }

    public Car getCar(Integer id) {
        return cars.get(id);
    }

    public List<Car> getAllCarWithMechanicId(int mechanicId) {
        List<Car> cars = new ArrayList<>();

        this.cars.forEach((_, v) -> {
            if (v.getMechanicId() == mechanicId) {
                cars.add(v);
            }
        });

        return cars;
    }

}