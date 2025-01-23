package com.pinnacle.bus.service;

import java.util.List;
import java.util.Optional;

import com.pinnacle.bus.model.Vehicle;

public interface VehicleService {

	public List<Vehicle> getAllVehicles();

    // Method to get a vehicle by its number
    public Optional<Vehicle> getVehicleByNumber(String number);

    // Method to create a vehicle
    public Vehicle createVehicle(Vehicle vehicle);

    // Method to update a vehicle by ID (changed from Long to String for MongoDB)
    public Optional<Vehicle> updateVehicle(String id, Vehicle vehicleDetails);

    // Method to delete a vehicle by ID (changed from Long to String for MongoDB)
    public void deleteVehicle(String id);
}
