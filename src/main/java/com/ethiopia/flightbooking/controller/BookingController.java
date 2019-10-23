package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.dto.Bookingdto;
import com.ethiopia.flightbooking.model.*;
import com.ethiopia.flightbooking.service.BookingService;
import com.ethiopia.flightbooking.service.FlightService;
import com.ethiopia.flightbooking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Controller
public class BookingController
{

    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;

    @Autowired
    NotificationService notificationService;


//    @GetMapping(value = {"/flightbooking/booking/new/{flightId}"})
//    public ModelAndView displayNewBookingForm(@PathVariable Integer flightId,@ModelAttribute("flightdto") Flightdto flightdto)
//    {
//        ModelAndView mav = new ModelAndView();
//        Flight flight = flightService.getFlightById(flightId);
//        Booking booking  = new Booking();
//        User user = new User();
//
//        if (flight != null) {
//            mav.addObject("flightdto",flightdto);
//            mav.addObject("booking",booking);
//            mav.addObject("flight",flight);
//            mav.addObject("user",user);
//            mav.setViewName("booking/new");
//            return mav;
//        }
//        mav.setViewName("searchresult");
//        return mav;
//    }



//    @GetMapping(value = {"/flightbooking/booking/new/{flightId}/{flightCount}/{adult}/{children}/{flightClass}"})
//    public String displayNewBookingForm(@PathVariable Integer flightId,@PathVariable String flightCount,
//                                        @PathVariable Integer adult,@PathVariable Integer children,
//                                        @PathVariable FlightClass flightClass
//                                         ,Model model)
//    {
//        Flight flight = flightService.getFlightById(flightId);
//        Booking booking  = new Booking();
//        booking.setFlightCount(flightCount);
//        booking.setAdult(adult);
//        booking.setChildren(children);
//        booking.setFlightClass(flightClass);
//        User user = new User();
//
////        Flightdto flightdto = new Flightdto();
////        flightdto.setAdult(adult);
////        flightdto.setChildren(children);
////        flightdto.setFlightClass(flightClass);
////        flightdto.setFlightCount(flightCount);
//
//
//        if (flight != null) {
////            model.addAttribute("flightdto",flightdto);
//            model.addAttribute("booking",booking);
//            model.addAttribute("flight",flight);
//            model.addAttribute("user",user);
//            return "booking/new";
//        }
//        return "searchresult";
//    }






    @GetMapping(value = {"/flightbooking/booking/new/{flightId}/{flightCount}/{adult}/{children}/{flightClass}"})
    public String displayNewBookingForm(@PathVariable Integer flightId,@PathVariable String flightCount,
                                       @PathVariable Integer adult,@PathVariable Integer children,
                                      @PathVariable FlightClass flightClass
                                       ,Model model)
    {
        Flight flight = flightService.getFlightById(flightId);

        if (flight != null) {
            Bookingdto bookingdto = new Bookingdto();
            bookingdto.setDepartingFlight(flight);
            bookingdto.setAdult(adult);
            bookingdto.setChildren(children);
            bookingdto.setFlightClass(flightClass);
            bookingdto.setFlightCount(flightCount);

            model.addAttribute("bookingdto",bookingdto);

            return "booking/new";
        }
        return "searchresult";
    }











    @PostMapping(value = {"/flightbooking/booking/success"})
    public String AcceptNewBookingForm(@ModelAttribute("bookingdto") Bookingdto bookingdto,
                                       Model model,BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            model.addAttribute("bookingdto",bookingdto);

            return "booking/new";
        }

        Booking booking = new Booking();
        User user = new User();

        user.setFirstName(bookingdto.getFirstName());
        user.setLastName(bookingdto.getLastName());
        user.setUserName(bookingdto.getUserName());



        booking.setUser(user);
        booking.setDepartingFlight(bookingdto.getDepartingFlight());
        booking.setDateAndTimeOfBooking(LocalDateTime.now());

        booking.setAdult(bookingdto.getAdult());
        booking.setChildren(bookingdto.getChildren());
        booking.setFlightCount(bookingdto.getFlightCount());
        booking.setFlightClass(bookingdto.getFlightClass());
        booking.setConfirmationCode(bookingService.randomAlphaNumeric(20));



        String body = "\n"+"Dear "+booking.getUser().getFirstName()+"\n"+"Thank you For Choosing Team Ethiopia For your Booking!!!" + "\n"+ "\n" + "Your Booking Confirmation number is : " + booking.getConfirmationCode() + "\n"+ "\n"
                +"Flight Details: " + "\n" + "From: " + bookingdto.getDepartingFlight().getOrigin().getAirportCity()
                + "          " + "To: " + bookingdto.getDepartingFlight().getOrigin().getAirportCity() + "\n"
                + "Date: " + bookingdto.getDepartingFlight().getDepartureDate() + "\n"
                + "Time: " + bookingdto.getDepartingFlight().getDepartureTime() + "\n"
                + "Class: " + bookingdto.getFlightClass().toString() + "   Adults: " +bookingdto.getAdult() + "   Children: " +bookingdto.getChildren()
                ;


        notificationService.sendNotification("dawitgirma00@gmail.com",user.getUserName(),body,"Booking confirmation");



        booking = bookingService.saveBooking(booking);


        return "booking/success";


    }











}
