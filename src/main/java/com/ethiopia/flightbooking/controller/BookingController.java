package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController
{

    @Autowired
    FlightService flightService;

    @GetMapping(value = {"/flightbooking/booking/new/{flightId}"})
    public String displayNewBookingForm(@PathVariable Integer flightId,Model model)
    {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            model.addAttribute("flight", flight);
            return "booking/new";
        }
        return "searchresult";
    }

}
