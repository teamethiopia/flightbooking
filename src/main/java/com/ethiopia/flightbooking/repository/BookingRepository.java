package com.ethiopia.flightbooking.repository;

import com.ethiopia.flightbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>
{
    Booking findBookingByConfirmationCode(String confirmationCode);
}
