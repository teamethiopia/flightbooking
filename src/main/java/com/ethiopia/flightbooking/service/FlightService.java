package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.Flight;

public interface FlightService extends BaseService<Flight> {

    Flight validateFlight(String flightId);
}
