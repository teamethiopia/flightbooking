package com.ethiopia.flightbooking.controller;

import com.ethiopia.flightbooking.dto.Flightdto;
import com.ethiopia.flightbooking.model.FlightClass;
import com.ethiopia.flightbooking.model.Role;
import com.ethiopia.flightbooking.model.User;
import com.ethiopia.flightbooking.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

        User user = new User();
        user.setRole(Role.USER);

        modelAndView.addObject("user", user);
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



    @GetMapping(value = {"/flightbooking/user/login"})
    public ModelAndView login() {

        ModelAndView mav = new ModelAndView();
        User user = new User();
        mav.addObject("user",user);
        mav.setViewName("login");
        return mav;

    }


    @PostMapping(value = {"/flightbooking/user/login"})
    public String postlogin(Model model, @ModelAttribute("user") User userdto) {

    User user = userService.getUserByuserNameAndpasswWord(userdto.getUserName(),userdto.getPassWord());


    if(user == null)
    {
        return  "redirect:/flightbooking/user/login";
    }

        return  "redirect:/flightbooking/flight/list";

    }



    @GetMapping(value = {"/flightbooking/user/logout"})
    public String logout() {

        return "redirect:/flightbooking/home";
    }





}
