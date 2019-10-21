package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.Flight;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @GetMapping(value = {"/flightbooking", "/flightbooking/home"})
    public ModelAndView home()
    {
        ModelAndView mav = new ModelAndView();
        mav.addObject("flight",new Flight());
        mav.setViewName("index");
        return mav;
    }

}
