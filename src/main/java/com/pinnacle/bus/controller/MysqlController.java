package com.pinnacle.bus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.bus.model.Fare;
import com.pinnacle.bus.service.MySQLService;

@RestController
@RequestMapping("/api/fares")
public class MysqlController {

    private final MySQLService mySQLService;

    @Autowired
    public MysqlController(MySQLService mySQLService) {
        this.mySQLService = mySQLService;
    }

    @PostMapping
    public ResponseEntity<Fare> addFare(@RequestBody Fare fare) {
        mySQLService.addFare(fare);
        return new ResponseEntity<>(fare, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Fare>> getAllFares() {
        try {
            List<Fare> fares = mySQLService.getAllFares();
            return new ResponseEntity<>(fares, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fare> getFareById(@PathVariable("id") String id) {
        try {
            Fare fare = mySQLService.getFare(id);
            if (fare != null) {
                return new ResponseEntity<>(fare, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fare> updateFare(@PathVariable("id") String id, @RequestBody Fare fare) {
        try {
            Fare existingFare = mySQLService.getFare(id);
            if (existingFare != null) {
                fare.setId(id);
                mySQLService.addFare(fare);
                return new ResponseEntity<>(fare, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFare(@PathVariable("id") String id) {
        try {
            Fare fare = mySQLService.getFare(id);
            if (fare != null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
