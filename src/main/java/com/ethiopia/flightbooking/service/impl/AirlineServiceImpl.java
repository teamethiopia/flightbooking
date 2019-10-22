package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.repository.AirlineRepository;
import com.ethiopia.flightbooking.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineService
{
    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public Page<Airline> getAllAirlinesPaged(int pageNo) {
        return airlineRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public List<Airline> getAllAirlinesList() {
        return airlineRepository.findAll();
    }

    @Override
    public Airline getAirlineById(Integer id) {
        return airlineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAirlineById(Integer id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }
}
