package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AirlineController
{

    @Autowired
    AirlineService airlineService;

    @GetMapping(value = {"/flightbooking/airline/list"})
    public ModelAndView list(@RequestParam(defaultValue = "0") int pageNo)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airlines", airlineService.getAllAirlinesPaged(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("airline/list");
        return modelAndView;
    }

    @GetMapping(value = {"/flightbooking/airline/new"})
    public String displayNewAirlineForm(Model model) {
        model.addAttribute("airline", new Airline());
        return "airline/new";
    }


}
