package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.repository.FlightRepository;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public Flight findOne(Integer id) {
        Optional<Flight> flight=flightRepository.findById(id);
        return flight.orElse(null);
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll(Sort.by("flightId"));
    }


}
