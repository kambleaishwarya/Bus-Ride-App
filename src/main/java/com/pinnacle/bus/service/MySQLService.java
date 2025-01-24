package com.pinnacle.bus.service;

import java.util.List;

import com.pinnacle.bus.model.Fare;

public interface MySQLService {

     void addFare(Fare fare);

    Fare getFare(String id);

    List<Fare> getAllFares();  
}