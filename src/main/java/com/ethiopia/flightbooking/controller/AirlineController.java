package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.Airline;
import com.ethiopia.flightbooking.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @PostMapping(value = "/flightbooking/airline/new")
    public String addNewAirline(@Valid @ModelAttribute("airline") Airline airline,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airline/new";
        }
        airline = airlineService.saveAirline(airline);
        return "redirect:/flightbooking/airline/list";
    }



    @GetMapping(value = {"/flightbooking/airline/edit/{airlineId}"})
    public String editAirline(@PathVariable Integer airlineId, Model model) {
        Airline airline = airlineService.getAirlineById(airlineId);
        if (airline != null) {
            model.addAttribute("airline", airline);
            return "airline/edit";
        }
        return "airline/list";
    }

    @PostMapping(value = {"/flightbooking/airline/edit"})
    public String UpdateAirline(@Valid @ModelAttribute("airline") Airline airline,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airline/edit";
        }
        airline = airlineService.saveAirline(airline);
        return "redirect:/flightbooking/airline/list";
    }



    @GetMapping(value = {"/flightbooking/airline/delete/{airlineId}"})
    public String deleteBook(@PathVariable Integer airlineId, Model model) {
        airlineService.deleteAirlineById(airlineId);
        return "redirect:/flightbooking/airline/list";
    }




}
