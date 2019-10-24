package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.model.User;
import com.ethiopia.flightbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping(value = {"/flightbooking/user/new"})
    public ModelAndView newuser() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", new User());
        modelAndView.setViewName("user/new");
        return modelAndView;
    }


    @PostMapping(value = "/flightbooking/user/new")
    public String addUser(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/new";
        }
        System.out.println("Dave");
        user = userService.saveUser(user);
        return "user/congra";
    }

}
