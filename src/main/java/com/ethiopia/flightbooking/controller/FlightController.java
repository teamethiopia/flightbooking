package com.ethiopia.flightbooking.controller;


//import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

//    ###############################################################################################
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)

    public String save(@Valid @ModelAttribute Flight flight , BindingResult result) {
        if(result.hasErrors())
            return "add-new-flight";
        flightService.saveFlight(flight);
        return "redirect:view-all-flight";

    }
  //  ################################################################################################

    @RequestMapping(value = {"/view-all-flight"})
    public ModelAndView viewAll(@RequestParam(defaultValue = "0") int pageno)
    {
        ModelAndView mav = new ModelAndView();
        Page<Flight> flights=flightService.getAllFlightsPaged(pageno);
        long numberOfFlight=flights.getTotalElements();
        mav.addObject("flights",flights);
        mav.addObject("currentPageno",pageno);
        mav.addObject("numberOfFlight",numberOfFlight);
        mav.addObject("flashBack","/flight/view-all-flight");
        mav.setViewName("flight-list");
        return mav;
    }
}
