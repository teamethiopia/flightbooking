package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.Airplane;
import com.ethiopia.flightbooking.model.Airport;
import com.ethiopia.flightbooking.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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


    @GetMapping(value = {"/flightbooking/airport/new"})
    public String displayNewAirportForm(Model model) {
        model.addAttribute("airport", new Airport());
        return "airport/new";
    }

    @PostMapping(value = "/flightbooking/airport/new")
    public String addNewAirportF(@Valid @ModelAttribute("airport") Airport airport,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airport/new";
        }
        airport = airportService.saveAirport(airport);
        return "redirect:/flightbooking/airport/list";
    }



    @GetMapping(value = {"/flightbooking/airport/edit/{airportId}"})
    public String editAirportF(@PathVariable Integer airportId, Model model) {
       Airport airport = airportService.getAirportById(airportId);
        if (airport != null) {
            model.addAttribute("airport", airport);
            return "airport/edit";
        }
        return "airport/list";
    }

    @PostMapping(value = {"/flightbooking/airport/edit"})
    public String UpdateAirportF(@Valid @ModelAttribute("airport") Airport airport,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airport/edit";
        }
        airport = airportService.saveAirport(airport);
        return "redirect:/flightbooking/airport/list";
    }



    @GetMapping(value = {"/flightbooking/airport/delete/{airportId}"})
    public String deleteAirportF(@PathVariable Integer airportId, Model model) {
        airportService.deleteAirportById(airportId);
        return "redirect:/flightbooking/airport/list";
    }





}
