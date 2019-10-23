package com.ethiopia.flightbooking.service.impl;

import com.ethiopia.flightbooking.model.Booking;
import com.ethiopia.flightbooking.repository.BookingRepository;
import com.ethiopia.flightbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class BookingServiceImpl implements BookingService
{

    @Autowired
    BookingRepository bookingRepository;


    @Override
    public Page<Booking> getAllBookingsPaged(int pageNo) {
        return bookingRepository.findAll(PageRequest.of(pageNo,20));
    }

    @Override
    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBookingById(Integer id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public String randomAlphaNumeric(int count) {
          String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();




    }
}
