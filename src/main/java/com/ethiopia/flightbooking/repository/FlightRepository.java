package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

}
