package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.dto.Flightdto;
import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.model.Booking;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.model.FlightClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController
{

    @GetMapping(value = {"/","/flightbooking", "/flightbooking/home"})
    public ModelAndView home()
    {
        ModelAndView mav = new ModelAndView();
//        Flight flight = new Flight();
//        mav.addObject("flight",flight);
        mav.addObject("flightdto",new Flightdto());
        mav.addObject("first",FlightClass.FIRST);
        mav.addObject("business",FlightClass.BUSINESS);
        mav.addObject("economy",FlightClass.ECONOMY);
        mav.setViewName("index");
        return mav;
    }

}
