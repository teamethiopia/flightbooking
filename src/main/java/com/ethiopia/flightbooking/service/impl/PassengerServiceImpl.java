package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Passenger;
import com.ethiopia.flightbooking.repository.PassengerRepository;
import com.ethiopia.flightbooking.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService
{
    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public Page<Passenger> getAllPassengersPaged(int pageNo) {
        return passengerRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public Passenger getPassengerById(Integer id) {
        return passengerRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePassengerById(Integer id) {
        passengerRepository.deleteById(id);
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
