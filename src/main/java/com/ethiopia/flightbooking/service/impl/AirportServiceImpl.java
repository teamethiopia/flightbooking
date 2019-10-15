package com.ethiopia.flightbooking.service.impl;


import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.repository.AirportRepository;
import com.ethiopia.flightbooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class AirportServiceImpl implements AirportService
{

    @Autowired
    AirportRepository airportRepository;

    @Override
    public Page<Airport> getAllAirportsPaged(int pageNo) {
        return airportRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public Airport getAirportById(Integer id) {
        return airportRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAirportById(Integer id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }
}
