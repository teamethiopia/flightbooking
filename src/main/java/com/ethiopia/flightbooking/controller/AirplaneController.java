package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.Airplane;
import com.ethiopia.flightbooking.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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


    @GetMapping(value = {"/flightbooking/airplane/new"})
    public String displayNewAirplaneForm(Model model) {
        model.addAttribute("airplane", new Airplane());
        return "airplane/new";
    }

    @PostMapping(value = "/flightbooking/airplane/new")
    public String addNewAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airplane/new";
        }
        airplane = airplaneService.saveAirplane(airplane);
        return "redirect:/flightbooking/airplane/list";
    }



    @GetMapping(value = {"/flightbooking/airplane/edit/{airplaneId}"})
    public String editAirplane(@PathVariable Integer airplaneId, Model model) {
        Airplane airplane = airplaneService.getAirplaneById(airplaneId);
        if (airplane != null) {
            model.addAttribute("airplane", airplane);
            return "airplane/edit";
        }
        return "airplane/list";
    }

    @PostMapping(value = {"/flightbooking/airplane/edit"})
    public String UpdateAirplane(@Valid @ModelAttribute("airplane") Airplane airplane,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airplane/edit";
        }
        airplane = airplaneService.saveAirplane(airplane);
        return "redirect:/flightbooking/airplane/list";
    }



    @GetMapping(value = {"/flightbooking/airplane/delete/{airplaneId}"})
    public String deleteAirplane(@PathVariable Integer airplaneId, Model model) {
        airplaneService.deleteAirplaneById(airplaneId);
        return "redirect:/flightbooking/airplane/list";
    }



}
