package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Airline;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AirlineService
{
    Page<Airline> getAllAirlinesPaged(int pageNo);
    List<Airline> getAllAirlinesList();
    Airline getAirlineById(Integer id);
    void deleteAirlineById(Integer id);
    Airline saveAirline(Airline airline);
}
