package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Airport;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AirportService
{
    Page<Airport> getAllAirportsPaged(int pageNo);
    Airport getAirportById(Integer id);
    void deleteAirportById(Integer id);
    Airport saveAirport(Airport airport);
}
