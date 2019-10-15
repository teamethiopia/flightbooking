package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer>
{
}
