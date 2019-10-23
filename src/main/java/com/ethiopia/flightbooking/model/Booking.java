package com.ethiopia.flightbooking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer bookingId;

    @Column(name = "confirmationcode")
    private String confirmationCode;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Passenger passenger;
    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Flight departingFlight;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Flight returningFlight;

    @Column(name = "dateandtimeofbooking")
    private LocalDateTime dateAndTimeOfBooking;

    @Column(name = "flightclass")
    private FlightClass flightClass;

    @Column(name = "adult")
    @Digits(integer = 9, fraction = 0)
    private Integer adult;
    @Column(name = "children")
    @Digits(integer = 9, fraction = 0)
    private Integer children;
    @Column(name = "flightcount")
    private String flightCount;


}
