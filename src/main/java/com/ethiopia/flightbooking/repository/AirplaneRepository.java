package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Airplane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane,Long> {

}
