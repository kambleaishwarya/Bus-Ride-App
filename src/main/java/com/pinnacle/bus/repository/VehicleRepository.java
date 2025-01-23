package com.pinnacle.bus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus.model.Vehicle;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Vehicle findByNumber(String number);
}
