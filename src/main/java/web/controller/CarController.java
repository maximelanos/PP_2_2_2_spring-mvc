package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarService;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String cars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<Car> listCars = new ArrayList<>();

        listCars.add(new Car("BMW", "X5", 1000000));
        listCars.add(new Car("BMW", "X6", 2000000));
        listCars.add(new Car("OPEL", "5", 700000));
        listCars.add(new Car("AUDI", "A8", 3000000));
        listCars.add(new Car("FORD", "3", 600000));
        listCars = carService.getListCar(listCars, count);
        model.addAttribute("listCars", listCars);
        return "cars";
    }
}
