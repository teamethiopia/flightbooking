package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Long> {
}
