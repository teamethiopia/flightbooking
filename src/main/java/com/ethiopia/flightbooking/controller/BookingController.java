package com.ethiopia.flightbooking.controller;



import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController
{

    @Autowired
    FlightService flightService;

    @GetMapping(value = {"/flightbooking/booking/new/{flightId}"})
    public ModelAndView displayNewBookingForm(@PathVariable Integer flightId)
    {
        ModelAndView mav = new ModelAndView();
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            mav.addObject("flight",flight);
            mav.setViewName("booking/new");
            return mav;
        }
        mav.setViewName("searchresult");
        return mav;
    }

}
