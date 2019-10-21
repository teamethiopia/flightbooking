package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AirportController
{

    @Autowired
    AirportService airportService;

    @GetMapping(value = {"/flightbooking/airport/list"})
    public ModelAndView list(@RequestParam(defaultValue = "0") int pageNo)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airports", airportService.getAllAirportsPaged(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("airport/list");
        return modelAndView;
    }

}
