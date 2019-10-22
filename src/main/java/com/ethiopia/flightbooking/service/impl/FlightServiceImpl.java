package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.repository.FlightRepository;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;



@Service
public class FlightServiceImpl implements FlightService
{
    @Autowired
    FlightRepository flightRepository;


    @Override
    public Page<Flight> getAllFlightsPaged(int pageNo) {
        return flightRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public Page<Flight> getSearchedFlightsPaged(int pageNo,String s) {
        return flightRepository.findFlightByOrigin_AirportCityContains(PageRequest.of(pageNo,20),s);
    }

    @Override
    public Flight getFlightById(Integer id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFlightById(Integer id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }






}
