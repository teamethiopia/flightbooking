package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Airline;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AirlineService
{
    Page<Airline> getAllAirlinesPaged(int pageNo);
    Airline getAirlineById(Integer id);
    void deleteAirlineById(Integer id);
    Airline saveAirline(Airline airline);
}
