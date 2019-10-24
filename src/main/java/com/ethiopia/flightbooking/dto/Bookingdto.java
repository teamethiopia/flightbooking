package com.ethiopia.flightbooking.dto;


import com.ethiopia.flightbooking.model.Flight;
import com.ethiopia.flightbooking.model.FlightClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bookingdto
{
    private String firstName;

    private String lastName;

    private String userName;

    private String passWord;

    Flight departingFlight;

    private FlightClass flightClass;

    @Digits(integer = 9, fraction = 0)
    private Integer adult;

    @Digits(integer = 9, fraction = 0)
    private Integer children;

    private String flightCount;




}
