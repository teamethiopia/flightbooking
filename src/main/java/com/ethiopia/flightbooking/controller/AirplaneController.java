package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AirplaneController
{
    @Autowired
    AirplaneService airplaneService;

    @GetMapping(value = {"/flightbooking/airplane/list"})
    public ModelAndView list(@RequestParam(defaultValue = "0") int pageNo)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("airplanes", airplaneService.getAllAirplanesPaged(pageNo));
        modelAndView.addObject("currentPageNo", pageNo);
        modelAndView.setViewName("airplane/list");
        return modelAndView;
    }


}
