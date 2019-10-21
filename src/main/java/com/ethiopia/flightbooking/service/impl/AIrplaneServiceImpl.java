package com.ethiopia.flightbooking.service.impl;


import com.ethiopia.flightbooking.model.Airplane;
import com.ethiopia.flightbooking.repository.AirplaneRepository;
import com.ethiopia.flightbooking.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AIrplaneServiceImpl implements AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    @Override
    public Long saveAirplane(Airplane airplane) {
        Airplane savedAirplane=airplaneRepository.save(airplane);
        return savedAirplane.getId();
    }

    @Override
    public List<Airplane> findAll() {
        return (List<Airplane>) airplaneRepository.findAll();
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Airplane findOne(Long id) {
        Optional<Airplane> airplane=airplaneRepository.findById(id);
        return airplane.orElse(null);
    }

    @Override
    public void delete(Long id) {
    airplaneRepository.deleteById(id);
    }
}
