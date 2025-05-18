package gpb.adminka.controller;

import gpb.adminka.model.Car;
import gpb.adminka.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cars")
public class CarMvcController {

    private final CarRepository carRepository;

    @Autowired
    public CarMvcController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public String getAllCars(Model model) {
        Map<Integer, Car> cars = carRepository.getCars();
        model.addAttribute("cars", cars.values());
        return "cars/list";
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable int id, Model model) {
        Car car = carRepository.getCar(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "cars/details";
        } else {
            return "error";
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("car", new Car());
        return "cars/create";
    }

    @PostMapping("/create")
    public String createCar(@ModelAttribute Car car) {
        carRepository.getCars().put(car.getId(), car);
        return "redirect:/cars";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Car car = carRepository.getCar(id);
        if (car != null) {
            model.addAttribute("car", car);
            return "cars/edit";
        } else {
            return "error";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateCar(@PathVariable int id, @ModelAttribute Car updatedCar) {
        Car existingCar = carRepository.getCar(id);
        if (existingCar != null) {
            updatedCar.setId(id);
            carRepository.getCars().put(id, updatedCar);
            return "redirect:/cars";
        } else {
            return "error";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteCar(@PathVariable int id) {
        Car car = carRepository.getCar(id);
        if (car != null) {
            carRepository.getCars().remove(id);
        }
        return "redirect:/cars";

    }

    @GetMapping("/mechanic/{mechanicId}")
    public String getCarsByMechanicId(@PathVariable int mechanicId, Model model) {
        List<Car> cars = carRepository.getAllCarWithMechanicId(mechanicId);
        model.addAttribute("cars", cars);
        return "cars/mechanic-list";
    }
}