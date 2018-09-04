package com.hcl.springboottdd.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
    Car findByName(String name);
}
