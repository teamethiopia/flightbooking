package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Integer>
{

    Page<Flight> findFlightByOrigin_AirportCityContains(Pageable pageable,String destination);






}
