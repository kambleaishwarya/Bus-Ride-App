package com.pinnacle.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.Fare;
import com.pinnacle.bus.repository.MySQLRepository;
import com.pinnacle.bus.service.MySQLService;

@Service
public class MySQLServiceImpl implements MySQLService {
    
     private final MySQLRepository mySqlRepository;

    @Autowired
    public MySQLServiceImpl(MySQLRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }

    @Override
    public void addFare(Fare fare) {
        mySqlRepository.insertFare(fare);
    }

    @Override
    public Fare getFare(String id) {
        return mySqlRepository.getFareById(id);
    }

    @Override
    public List<Fare> getAllFares() {
        return mySqlRepository.getAllFares();
    }
}
