package com.pinnacle.bus.service;

import com.pinnacle.bus.model.Vehicle;

public interface  MongoService {
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle getVehicleById(String id);
    Vehicle updateVehicle(String id, Vehicle vehicle);
    void deleteVehicle(String id);
    
}