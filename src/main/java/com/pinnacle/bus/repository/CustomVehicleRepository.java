package com.pinnacle.bus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus.model.Vehicle;

@Repository
public class CustomVehicleRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Vehicle save(Vehicle vehicle) {
        return mongoTemplate.save(vehicle);
    }

    public List<Vehicle> findAll() {
        return mongoTemplate.findAll(Vehicle.class);
    }

    public Vehicle findById(String id) {
        return mongoTemplate.findById(id, Vehicle.class);
    }

    public Vehicle findByNumber(String number) {
        Query query = new Query(Criteria.where("number").is(number));
        return mongoTemplate.findOne(query, Vehicle.class);
    }

    public Vehicle update(String id, Vehicle vehicle) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
            .set("name", vehicle.getName())
            .set("number", vehicle.getNumber())
            .set("seats", vehicle.getSeats())
            .set("type", vehicle.getType());
        
        return mongoTemplate.findAndModify(query, update, Vehicle.class);
    }

    public void delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Vehicle.class);
    }

    public List<Vehicle> findByType(String type) {
        Query query = new Query(Criteria.where("type").is(type));
        return mongoTemplate.find(query, Vehicle.class);
    }
}