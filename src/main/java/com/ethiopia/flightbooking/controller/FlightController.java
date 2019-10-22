package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.dto.Flightdto;
import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.model.Airplane;
import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.AirlineService;
import com.ethiopia.flightbooking.service.AirplaneService;
import com.ethiopia.flightbooking.service.AirportService;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightController
{

    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    AirportService airportService;





    @GetMapping(value = {"/flightbooking/flight/list"})
    public ModelAndView list(@RequestParam(defaultValue = "0") int pageNo)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("flights", flightService.getAllFlightsPaged(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("flight/list");
        return modelAndView;
    }

    @PostMapping(value = {"/flightbooking/flight/search"})
    public String searchFlight(@ModelAttribute("flightdto") Flightdto flightdto,
                             BindingResult bindingResult, Model model,@RequestParam(defaultValue = "0") int pageNo) {

//        System.out.println(flightdto.getFlightCount());
//        System.out.println(flightdto.getFlightClass());
//        System.out.println(flightdto.getChildren());
//        System.out.println(flightdto.getAdult());
//        System.out.println(flightdto.getFrom());
//        System.out.println(flightdto.getTo());
//        System.out.println(flightdto.getDateOfDeparture());
//        System.out.println(flightdto.getDateOfReturn());

      //  model.addAttribute("flights",flightService.getSearchedFlightsPaged(pageNo,flight.getFlightNumber()));
        return "searchresult";
    }



    @GetMapping(value = "/flightbooking/flight/new")
    public String newFlightForm(Model model) {
        List<Airline> airlines = airlineService.getAllAirlinesList();
        List<Airplane> airplanes = airplaneService.getAllAirplanesList();
        List<Airport> airports = airportService.getAllAirports();
        model.addAttribute("flight", new Flight());
        model.addAttribute("airlines", airlines);
        model.addAttribute("airplanes", airplanes);
        model.addAttribute("airports", airports);
        return "flight/new";
    }


    @PostMapping(value = "/flightbooking/flight/new")
    public String addNewFlight(@Valid @ModelAttribute("flight") Flight flight,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            List<Airline> airlines = airlineService.getAllAirlinesList();
            List<Airplane> airplanes = airplaneService.getAllAirplanesList();
            List<Airport> airports = airportService.getAllAirports();
            model.addAttribute("flight", new Flight());
            model.addAttribute("airlines", airlines);
            model.addAttribute("airplanes", airplanes);
            model.addAttribute("airports", airports);
            return "flight/new";
        }
        flight = flightService.saveFlight(flight);
        return "redirect:/flightbooking/flight/list";
    }





    @GetMapping(value = {"/flightbooking/flight/edit/{flightId}"})
    public String editFlight(@PathVariable Integer flightId, Model model) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            model.addAttribute("flight", flight);
            List<Airline> airlines = airlineService.getAllAirlinesList();
            List<Airplane> airplanes = airplaneService.getAllAirplanesList();
            List<Airport> airports = airportService.getAllAirports();
            model.addAttribute("airlines", airlines);
            model.addAttribute("airplanes", airplanes);
            model.addAttribute("airports", airports);
            return "flight/edit";
        }
        return "flight/list";
    }

    @PostMapping(value = {"/flightbooking/flight/edit"})
    public String UpdateFlight(@Valid @ModelAttribute("flight") Flight flight,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "flight/edit";
        }
        flight = flightService.saveFlight(flight);
        return "redirect:/flightbooking/flight/list";
    }

    @GetMapping(value = {"/flightbooking/flight/delete/{flightId}"})
    public String deleteBook(@PathVariable Integer flightId, Model model) {
        flightService.deleteFlightById(flightId);
        return "redirect:/flightbooking/flight/list";
    }




}
