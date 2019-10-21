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
        BookingService bookingService;

        @Autowired
        FlightService flightService;

        @Autowired
        AirlineService airlineService;

        @Autowired
        AirportService airportService;

        @Autowired
        AirplaneService airplaneService;

        @ModelAttribute("airlines")
        public List<Airline> getAirlines() {
            return airlineService.findAll();
        }

        @ModelAttribute("airports")
        public List<Airport> getAirports() {
            return airportService.findAll();
        }

        @ModelAttribute("airplanes")
        public List<Airplane> getAirplanes() {
            return airplaneService.findAll();
        }

        @GetMapping(value = {"","/","/book"})
        public String getFlights(Model model){
            model.addAttribute("flights", flightService.findAll());
            return "booking/index";
        }



        @GetMapping(value = "/bookingForm")
        public String getBookingForm(@ModelAttribute("passenger") Passenger passenger, @RequestParam("id") Long id, Model model){
            System.out.println(id);
            model.addAttribute("flightId", id);
            return "booking/new";
        }

        @PostMapping(value = "/booking")
        public String doBooking(@Valid @ModelAttribute("passenger")Passenger passenger, @RequestParam("flightId") long id, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
            if(bindingResult.hasErrors()){
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "booking/new";
            }
            System.out.println(id);
            model.addAttribute("flight", flightService.findOne(id));
            List<Booking> bookings= passenger.getBookings();

            return "booking/detail";
        }


    }
