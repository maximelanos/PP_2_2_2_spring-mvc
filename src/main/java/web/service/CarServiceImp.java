package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImp implements CarService {
    private static int count;
    private List<Car> listCars;

    @Override
    public List<Car> getListCar(List<Car> listCars, int count) {
        if (count == 0 || count > 5) {
            return listCars;
        }
        return listCars.stream().limit(count).collect(Collectors.toList());
    }

}
