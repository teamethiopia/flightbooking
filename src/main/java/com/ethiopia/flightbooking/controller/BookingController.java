package com.ethiopia.flightbooking.controller;


import com.ethiopia.flightbooking.dto.Bookingdto;
import com.ethiopia.flightbooking.model.*;
import com.ethiopia.flightbooking.service.BookingService;
import com.ethiopia.flightbooking.service.FlightService;
import com.ethiopia.flightbooking.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class BookingController
{

    @Autowired
    FlightService flightService;

    @Autowired
    BookingService bookingService;

    @Autowired
    NotificationService notificationService;










    @GetMapping(value = "/flightbooking/booking/search")
    public String searchbooking() {
        return "booking/search";
    }


    @PostMapping(value = "/flightbooking/booking/search{confirmationCode}")
    public ModelAndView searchbookingsubmit(@RequestParam String confirmationCode) {
        ModelAndView mav = new ModelAndView();
        Booking booking = bookingService.getBookingByconfirmationCode(confirmationCode);
        mav.addObject("booking",booking);
        System.out.println(confirmationCode);
        mav.setViewName("booking/search");

        return mav;
    }


    @GetMapping(value = {"/flightbooking/booking/delete/{bookingId}"})
    public String deleteBook(@PathVariable Integer bookingId, Model model) {
        bookingService.deleteBookingById(bookingId);
        return "booking/search";
    }










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
