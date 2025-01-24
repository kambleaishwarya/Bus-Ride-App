package com.pinnacle.bus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pinnacle.bus.model.User;
import com.pinnacle.bus.repository.PostgreSQLRepository;
import com.pinnacle.bus.service.PostgreSQLService;


@Service
public class PostgreSQLServiceImpl implements  PostgreSQLService{

    @Autowired
    private PostgreSQLRepository postgreSQLRepository;

    @Override
    public User findById(String id) {
        return postgreSQLRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return postgreSQLRepository.findAll();
    }

    @Override
    public int save(User user) {
        return postgreSQLRepository.save(user);
    }

    @Override
    public int update(User user) {
        return postgreSQLRepository.update(user);
    }

    @Override
    public int delete(String id) {
        return postgreSQLRepository.delete(id);
    }
}
