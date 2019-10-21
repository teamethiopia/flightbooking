package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Airplane;

public interface AirplaneService extends BaseService<Airplane> {

    Long saveAirplane(Airplane airplane);
}
