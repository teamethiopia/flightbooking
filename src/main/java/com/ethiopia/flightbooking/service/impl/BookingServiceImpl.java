package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Booking;
import com.ethiopia.flightbooking.repository.BookingRepository;
import com.ethiopia.flightbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findBookingByCC(String cCode) {
        return bookingRepository.findBookingByConfirmationCode(cCode);
    }
}
