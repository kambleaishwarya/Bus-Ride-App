package com.pinnacle.bus.service;

import java.util.List;
import java.util.Optional;

import com.pinnacle.bus.model.Vehicle;

public interface VehicleService {

	public List<Vehicle> getAllVehicles();

    public Optional<Vehicle> getVehicleByNumber(String number);

    public Vehicle createVehicle(Vehicle vehicle);

    public Optional<Vehicle> updateVehicle(String id, Vehicle vehicleDetails);

    public void deleteVehicle(String id);
}
