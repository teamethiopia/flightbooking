package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE confirmationCode = :cCode")
    public Booking findBookingByConfirmationCode(@Param(value = "cCode") String cCode);

}
