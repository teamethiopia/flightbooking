package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline,Long> {

}
