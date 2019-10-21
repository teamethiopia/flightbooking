package com.ethiopia.flightbooking.service;


import com.ethiopia.flightbooking.model.Booking;

public interface BookingService {

    Booking saveBooking(Booking booking);
    Booking findBookingByCC(String cCode);
}
