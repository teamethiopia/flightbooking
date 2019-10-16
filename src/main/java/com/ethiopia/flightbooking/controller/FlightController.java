package com.ethiopia.flightbooking.controller;


//import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping("/add_new_flight")
    public String addFlight(Model model){

        model.addAttribute("flights",new Flight());
       return "add-new-flight" ;
    }
//    @RequestMapping("/save")
//
//    public String save(@Valid @ModelAttribute Flight flight , BindingResult result) {
//        if(result.hasErrors())
//            return "add-new-flight";
//        flightService.saveFlight(flight);
//        return "redirect:/flightbooking";
//
//    }
//    @GetMapping(value = {"/","/flightbooking", "/flightbooking/home"})
//    public ModelAndView home()
//    {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("flight",new Flight());
//        mav.setViewName("index");
//        return mav;
//    }
}