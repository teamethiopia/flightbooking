package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface FlightService
{
    Page<Flight> getAllFlightsPaged(int pageNo);
    Flight getFlightById(Integer id);
    void deleteFlightById(Integer id);
    Flight saveFlight(Flight flight);

}
