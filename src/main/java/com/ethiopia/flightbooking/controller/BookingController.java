package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.model.*;
import com.ethiopia.flightbooking.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookingController
{
    @Autowired
    FlightService flightService;

   @Autowired
    PassengerService passengerService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirportService airportService;

    @Autowired
    AirplaneService airplaneService;

    @GetMapping(value = {"","/","/book"})
    public String getFlights(Model model){
        model.addAttribute("flights", flightService.findAll());
        return "booking/index";
    }

    @GetMapping(value = {"/flightbooking/booking/new"})
    public String bookingForm(@ModelAttribute("passenger") Passenger passenger, @RequestParam("id") int id, Model model){
        //System.out.println(id);
        model.addAttribute("flightId", id);
        return "booking/new";
    }
    @PostMapping(value = "/flightbooking/booking/new")
    public String doBooking( Passenger passenger, BindingResult bindingResult, @RequestParam("flightId") String id,
                             Model model, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "booking/new";
        }
        //model.addAttribute("passenger", passengerService.savePassenger(passenger));
        redirectAttributes.addFlashAttribute("passenger", passengerService.savePassenger(passenger));
        System.out.println(id);
        redirectAttributes.addFlashAttribute("flight", flightService.findOne(Integer.parseInt(id)));
       // model.addAttribute("flight", flightService.findOne(id));
       // List<Booking> bookings= passenger.getBookings();
        //System.out.println("passengerService.savePassenger(passenger).toString()");

        return "redirect:/flightbooking/booking/detail";
    }
    @GetMapping("/flightbooking/booking/detail")
    public String details() {
        return "booking/detail";
    }

}
