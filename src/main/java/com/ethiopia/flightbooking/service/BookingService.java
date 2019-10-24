package com.ethiopia.flightbooking.service;

import com.ethiopia.flightbooking.model.Booking;
import org.springframework.data.domain.Page;


public interface BookingService
{
    Page<Booking> getAllBookingsPaged(int pageNo);
    Booking getBookingById(Integer id);
    void deleteBookingById(Integer id);
    Booking saveBooking(Booking flight);
    String randomAlphaNumeric(int count);
    Booking getBookingByconfirmationCode(String confirmationCode);

}
