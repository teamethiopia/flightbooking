package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.Airplane;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AirplaneService
{
    Page<Airplane> getAllAirplanesPaged(int pageNo);
    List<Airplane> getAllAirplanesList();
    Airplane getAirplaneById(Integer id);
    void deleteAirplaneById(Integer id);
    Airplane saveAirplane(Airplane airplane);
}
