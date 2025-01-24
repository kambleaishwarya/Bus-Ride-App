package com.pinnacle.bus.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.Vehicle;
import com.pinnacle.bus.repository.CustomVehicleRepository;
import com.pinnacle.bus.service.MongoService;

@Service
public class MongoServiceImpl implements  MongoService{

    @Autowired
    private final CustomVehicleRepository mongoRepository;

    public MongoServiceImpl(CustomVehicleRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return mongoRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return mongoRepository.findById(id);
    }

    @Override
    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        vehicle.setId(id);
        return mongoRepository.update(id, vehicle);
    }

    @Override
    public void deleteVehicle(String id) {
        mongoRepository.delete(id);
    }
}