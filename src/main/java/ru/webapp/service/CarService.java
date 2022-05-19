package ru.webapp.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.webapp.model.Car;
import ru.webapp.model.CarRepository;

@Service
public class CarService implements WebService<Car> {
    
    @Autowired
    private CarRepository repo;

    @Override
    public Iterable<Car> getAll() {
        return repo.findAll();
    }

    @Override
    public Car getById(Long id) {
        var opt = repo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Car> getByName(String name) {
        List<Car> cars = new ArrayList<>();
        for (Car car : repo.findAll()) {
            if (car.getName().contains(name)) {
                cars.add(car);
            }
        }

        return cars;
    }

    @Override
    public void add(Car car) {
        repo.save(car);
    }
}