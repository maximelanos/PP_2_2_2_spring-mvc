package web.dao;

import web.models.Car;

import java.util.List;

public interface CarDao {
    List<Car> getList();

    List<Car> getListCar(List<Car> list, int count);
}
