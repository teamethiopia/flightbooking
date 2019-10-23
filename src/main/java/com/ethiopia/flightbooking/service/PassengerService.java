package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Passenger;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface PassengerService
{
    Page<Passenger> getAllPassengersPaged(int pageNo);
    Passenger getPassengerById(Integer id);
    void deletePassengerById(Integer id);
    Passenger savePassenger(Passenger passenger);
}
