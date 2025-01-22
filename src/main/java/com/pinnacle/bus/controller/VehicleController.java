package com.pinnacle.bus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus.model.Vehicle;
import com.pinnacle.bus.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles() {
        System.out.println("Fetching vehicles...");

        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{number}")
    public ResponseEntity<Vehicle> getVehicleByNumber(@PathVariable String number) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleByNumber(number);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/vehicles")
    public ResponseEntity<String> createVehicle(@RequestBody Vehicle vehicle) {
        System.out.println("Received vehicle: " + vehicle);
        Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
        return ResponseEntity.status(201).body("Vehicle created successfully with ID: " + createdVehicle.getId());
    }

    @PutMapping("/vehicles/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
        return updatedVehicle.map(v -> ResponseEntity.ok("Vehicle updated successfully"))
                .orElseGet(() -> ResponseEntity.status(404).body("Vehicle not found"));
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable String id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(200).body("Vehicle deleted successfully");
    }

}
