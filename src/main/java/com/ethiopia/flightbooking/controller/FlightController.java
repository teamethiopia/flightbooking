package com.ethiopia.flightbooking.controller;


//import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.model.Airplane;
import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.AirlineService;
import com.ethiopia.flightbooking.service.AirplaneService;
import com.ethiopia.flightbooking.service.AirportService;
import com.ethiopia.flightbooking.service.FlightService;
import com.ethiopia.flightbooking.validator.FlightScheduleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightScheduleValidator flightScheduleValidator;


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

    @GetMapping(value = {"/admin"})
    public String getFlights(Model model) {
        model.addAttribute("flights", flightService.findAll());
        return "home/index";
    }

    @GetMapping(value = "/flight/new")
    public String newFlightForm(@ModelAttribute("flight") Flight flight, Model model) {
        return "flight/new";
    }

    @RequestMapping(value = "/flight/new", method = RequestMethod.POST)
    public String scheduleNewFlight(@Valid @ModelAttribute("flight") Flight flight,
                                    BindingResult bindingResult, Model model) {
        flightScheduleValidator.validate(flight, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/flight/new";
        }
        flight= flightService.save(flight);
        return "redirect:/admin";
    }



    @GetMapping(value = "/flight/{id}")
    public String getFlightDetail(@PathVariable("id") Long id, Model model) {
        Flight flight = flightService.findOne(id);
        if (flight != null) {
            model.addAttribute("flight", flight);
            return "flight/edit";
        }
        return "/admin";
    }
    
    @PostMapping(value = "/flight")
    public String updateFlightSchedule(@Valid @ModelAttribute("flight") Flight flight, BindingResult bindingResult, Model model) {
        flightScheduleValidator.validate(flight, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "flight/edit";
        }

        flight = flightService.save(flight);
        return "redirect:/admin";

    }

}
