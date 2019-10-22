package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane,Integer>
{
}
