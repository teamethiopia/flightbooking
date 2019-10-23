package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Flight;
import org.springframework.data.domain.Page;

import java.util.List;


public interface FlightService
{
    public abstract Page<Flight> getAllFlightsPaged(int pageNo);
    public abstract Page<Flight> getSearchedFlightsPaged(int pageNo, String s);
    public abstract Flight getFlightById(Integer id);
    public abstract void deleteFlightById(Integer id);
    public abstract Flight saveFlight(Flight flight);
    public abstract Flight findOne(Integer id);
    public abstract List<Flight> findAll();

}
