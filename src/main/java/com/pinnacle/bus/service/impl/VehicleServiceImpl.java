package com.pinnacle.bus.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.Vehicle;
import com.pinnacle.bus.repository.VehicleRepository;
import com.pinnacle.bus.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getVehicleByNumber(String number) {
        return Optional.ofNullable(vehicleRepository.findByNumber(number));
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Optional<Vehicle> updateVehicle(Long id, Vehicle vehicleDetails) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        vehicle.ifPresent(v -> {
            v.setName(vehicleDetails.getName());
            v.setNumber(vehicleDetails.getNumber());
            v.setSeats(vehicleDetails.getSeats());
            v.setType(vehicleDetails.getType());
            vehicleRepository.save(v);
        });
        return vehicle;
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

}
