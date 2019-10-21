package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.dto.Flightdto;
import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.model.Booking;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FlightController
{

    @Autowired
    FlightService flightService;

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
    public String searchFlight(  @ModelAttribute("flight") Flight flight,@ModelAttribute("flightdto") Flightdto flightdto,
                             BindingResult bindingResult, Model model,@RequestParam(defaultValue = "0") int pageNo) {

//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "index";
//        }
        System.out.println(flightdto.getFlightCount());
        System.out.println(flightdto.getFlightClass());
        System.out.println(flightdto.getChildren());
        System.out.println(flightdto.getAdult());
        System.out.println(flightdto.getFrom());
        System.out.println(flightdto.getTo());
        System.out.println(flightdto.getDateOfDeparture());
        System.out.println(flightdto.getDateOfReturn());

        model.addAttribute("flights",flightService.getSearchedFlightsPaged(pageNo,flight.getFlightNumber()));
      //  model.addObject("flights",flightService.getSearchedFlightsPaged(pageNo,flight.getFlightNumber()));
        return "searchresult";
    }



}
