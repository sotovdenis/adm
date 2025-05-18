package gpb.adminka;

import gpb.adminka.model.Car;
import gpb.adminka.model.Mechanic;
import gpb.adminka.repository.CarRepository;
import gpb.adminka.repository.MechanicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final MechanicRepository mechanicRepository;
    private final CarRepository carRepository;

    public DataLoader(MechanicRepository mechanicRepository, CarRepository carRepository) {
        this.mechanicRepository = mechanicRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        HashMap<Integer, Mechanic> mechanics = new HashMap<>();
        mechanics.put(1, new Mechanic(1, "John Doe", 8));
        mechanics.put(2, new Mechanic(2, "Jane Smith", 5));

        mechanicRepository.setMechanics(mechanics);

        HashMap<Integer, Car> cars = new HashMap<>();
        cars.put(1, new Car(1, "Toyota", "Camry", "Red", 2020, 1));
        cars.put(2, new Car(2, "Honda", "Civic", "Blue", 2019, 1));
        cars.put(3, new Car(3, "Ford", "Focus", "Black", 2021, 1));
        cars.put(4, new Car(4, "Chevrolet", "Malibu", "White", 2018, 1));
        cars.put(5, new Car(5, "Nissan", "Altima", "Silver", 2022, 1));
        cars.put(6, new Car(6, "BMW", "X5", "Gray", 2020, 2));
        cars.put(7, new Car(7, "Mercedes", "C-Class", "Black", 2019, 2));
        cars.put(8, new Car(8, "Audi", "A4", "Red", 2021, 2));
        cars.put(9, new Car(9, "Volkswagen", "Golf", "Blue", 2018, 2));
        cars.put(10, new Car(10, "Tesla", "Model 3", "White", 2022, 2));

        carRepository.setCars(cars);

        System.out.println("Initial data loaded successfully!");
    }
}