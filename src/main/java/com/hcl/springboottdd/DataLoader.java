package com.hcl.springboottdd;

import com.hcl.springboottdd.domain.Car;
import com.hcl.springboottdd.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private CarRepository carRepository;

    @Autowired
    public DataLoader(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void run(ApplicationArguments args) {
        carRepository.save(Car.builder().name("prius").type("hybrid").build());
    }
}