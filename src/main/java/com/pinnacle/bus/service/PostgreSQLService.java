package com.pinnacle.bus.service;

import java.util.List;

import com.pinnacle.bus.model.User;

public interface  PostgreSQLService {

    User findById(String id);

    List<User> findAll();

    int save(User user);

    int update(User user);

    int delete(String id);   
}
